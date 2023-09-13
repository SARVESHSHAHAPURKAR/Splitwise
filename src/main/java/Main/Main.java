package Main;

import models.Expense;
import models.User;
import services.ExpenseManagementService;
import services.UserManagementService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        Map<String, Double> creditMappings1 = new HashMap<>();
        Map<String, Double> creditMappings2 = new HashMap<>();
        Map<String, Double> creditMappings3 = new HashMap<>();
        Map<String, Double> creditMappings4 = new HashMap<>();


        Map<String, User> nameToUser = new HashMap<>();

        UserManagementService userService = new UserManagementService(users,nameToUser);
        ExpenseManagementService expenseManagementService = new ExpenseManagementService(userService);

        User u1 = new User("U1", creditMappings1);
        User u2 = new User("U2", creditMappings2);
        User u3 = new User("U3", creditMappings3);
        User u4 = new User("U4", creditMappings4);

        userService.addUser(u1); userService.addUser(u2); userService.addUser(u3); userService.addUser(u4);

        userService.show();

        Map<String, Double> contri1 = new HashMap<>();
        contri1.put("U1",1000.0);
        Map<String, Double> consum1 = new HashMap<>();
        consum1.put("U1",250.0);
        consum1.put("U2",250.0);
        consum1.put("U3",250.0);
        consum1.put("U4",250.0);
        Expense expense1 = new Expense(1000.0, contri1, consum1);

        expenseManagementService.distributeExpense(expense1);
        userService.showForUser(u4);
        userService.showForUser(u1);

        Map<String, Double> contri2 = new HashMap<>();
        contri2.put("U1",1250.0);
        Map<String, Double> consum2 = new HashMap<>();
        consum2.put("U2",370.0);
        consum2.put("U3",880.0);
        Expense expense2 = new Expense(1250.0, contri2, consum2);

        expenseManagementService.distributeExpense(expense2);
        userService.show();

        Map<String, Double> contri3 = new HashMap<>();
        contri3.put("U4",1200.0);
        Map<String, Double> consum3 = new HashMap<>();
        consum3.put("U1",480.0);
        consum3.put("U2",240.0);
        consum3.put("U3",240.0);
        consum3.put("U4",240.0);
        Expense expense3 = new Expense(1200.0, contri3, consum3);

        expenseManagementService.distributeExpense(expense3);
        userService.showForUser(u1);
        userService.show();

    }
}