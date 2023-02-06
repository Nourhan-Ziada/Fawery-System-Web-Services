package com.fci.advanced.se.personsmanagement.User;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public final   class UserEntity {
    private static  UserEntity users ;
    public static Map<String, User> userMap = new HashMap<String, User>();
    public boolean addUser(User user){
         try {
             if (userMap.get(user.getAccount().getUsername()) != null) {
                 return false;
             }
             userMap.put(user.getAccount().getUsername(), user);
         } catch (Exception e) {
             System.out.println("Exception in addPerson as" + e.getMessage());
             return false;
         }
         return true;
     }
    public static User searchForUser(String userName)
    {
        for (Map.Entry<String,User> entry : userMap.entrySet()) {

            if (userMap.isEmpty())
                return null;

            else if (Objects.equals(entry.getValue().getAccount().getUsername(), userName)) {
                return entry.getValue();
            }
        }
        return null;
    }
    public User getUser(String userName, String password)
    {
        for (Map.Entry<String,User> entry : userMap.entrySet()) {

            if (userMap.isEmpty())
                return null;

            else if (Objects.equals(entry.getValue().getAccount().getUsername(), userName) && Objects.equals(entry.getValue().getAccount().getPassword(), password) ) {
                return entry.getValue();
            }
        }
        return null;
    }
    public boolean searchForPassword(String pass)
    {
        for (Map.Entry<String,User> entry : userMap.entrySet()) {

            if (userMap.isEmpty())
                return false;

            else if (Objects.equals(entry.getValue().getAccount().getPassword(), pass)) {
                return true;
            }
        }
        return false;

    }

}


