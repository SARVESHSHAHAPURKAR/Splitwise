package services;

import models.User;

import java.util.List;
import java.util.Map;

public class UserManagementService {

    List<User> users;

    Map<String, User> nameToUserMapping;

    public UserManagementService(List<User> users, Map<String, User> nameToUserMapping) {
        this.users = users;
        this.nameToUserMapping = nameToUserMapping;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Map<String, User> getNameToUserMapping() {
        return nameToUserMapping;
    }

    public void setNameToUserMapping(Map<String, User> nameToUserMapping) {
        this.nameToUserMapping = nameToUserMapping;
    }

    public void addUser(User user){
        users.add(user);

        nameToUserMapping.put(user.getName(),user);
    }

    public void show(){

        for(User user: users){

            for(String userName: user.getCreditMappings().keySet()){

                if(user.getCreditMappings().get(userName)>0){
                    System.out.println(user.getName()+" owes "+userName+" amount of "+user.getCreditMappings().get(userName));
                }
            }
        }
    }

    public void showForUser(User user){

        for(String name: user.getCreditMappings().keySet()){

            if(!user.getName().equalsIgnoreCase(name)) {
                if (user.getCreditMappings().get(name) > 0) {
                    System.out.println(user.getName() + " owes " + name + " amount of " + user.getCreditMappings().get(name));
                } else {
                    System.out.println(name + " owes " + user.getName() + " amount of " + -1 * (user.getCreditMappings().get(name)));
                }
            }
        }

    }
}
