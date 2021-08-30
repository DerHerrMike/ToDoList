package com.mps.todolist.service;

import com.mps.todolist.dao.UserDAO;
import com.mps.todolist.model.User;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Optional;


/**
 * / Created by Mike Schwingenschloegl in Aug 2021
 */
public class UserService {

    public static int createUser(String email, String password) throws ServiceInputException {

        //pw plaintext  --> hash + slat

        String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());

        email = email.toLowerCase();

        //Gibt es schon einen User mit dieser Emailadresse?
        if (getUserByEmail(email).isPresent()) {
            throw new ServiceInputException("User mit dieser Emailadresse existiert bereits");
        }

        //User in DB einfügen
        return UserDAO.createUser(email, passwordHash);

    }

    public static Optional<User> getUserByEmail(String email) {

        email = email.toLowerCase();

        return UserDAO.getUserByEmail(email);


    }

    public static Optional<User> getUserById(int id){
        return UserDAO.getUserByID(id);

    }

    public static Optional<User> login(String email, String password) {

        Optional<User> optionalUser = getUserByEmail(email);
        if (optionalUser.isEmpty()) {
            return Optional.empty();
        }
        //PW überprüfen
        boolean passwordOk = BCrypt.checkpw(password, optionalUser.get().getPassword());

        if(passwordOk){
            return optionalUser;
        }
        return Optional.empty();

    }


}
