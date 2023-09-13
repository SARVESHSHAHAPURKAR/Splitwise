package services;

import models.Expense;
import models.User;

public class ExpenseManagementService {

    UserManagementService userService;

    public ExpenseManagementService(UserManagementService userService) {
        this.userService = userService;
    }

    public UserManagementService getUserService() {
        return userService;
    }

    public void setUserService(UserManagementService userService) {
        this.userService = userService;
    }

    public void distributeExpense(Expense expense){

        if (!validateExpense(expense)){
            System.out.println("The given expense of amount "+expense.getTotalSpend()+" is invalid");
        }

        for(String userName : expense.getConsumptions().keySet()){

            User user = userService.getNameToUserMapping().get(userName);

            for(String userNameGiver : expense.getContributions().keySet()){

                if(!userNameGiver.equalsIgnoreCase(user.getName())) {
                    User userGiver = userService.getNameToUserMapping().get(userNameGiver);

                    Double oweAmountForReceiver = user.getCreditMappings().getOrDefault(userNameGiver, 0.0);
                    Double oweAmountForGiver = userGiver.getCreditMappings().getOrDefault(user.getName(), 0.0);


                    Double incurredExpense = (expense.getContributions().get(userNameGiver) / expense.getTotalSpend()) * (expense.getConsumptions().get(user.getName()));

                    user.getCreditMappings().put(userNameGiver, oweAmountForReceiver + incurredExpense);

                    userGiver.getCreditMappings().put(user.getName(), oweAmountForGiver - incurredExpense);
                }

            }
        }

    }

    private boolean validateExpense(Expense expense) {

        Double totalSpend=0.0;
        Double totalConsumption=0.0;

        for(String user : expense.getContributions().keySet()){

            totalSpend+= expense.getContributions().get(user);
        }

        for(String user: expense.getConsumptions().keySet()){

            totalConsumption+=expense.getConsumptions().get(user);
        }

        return ((totalSpend == expense.getTotalSpend()) && (totalConsumption==expense.getTotalSpend()));
    }
}
