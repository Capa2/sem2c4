package business.services;

import business.entities.User;
import business.persistence.Database;
import business.persistence.UserMapper;
import business.exceptions.UserException;

import java.util.ArrayList;

public class UserFacade
{
    UserMapper userMapper;

    public UserFacade(Database database)
    {
        userMapper = new UserMapper(database);
    }

    public User login(String email, String password) throws UserException
    {
        return userMapper.login(email, password);
    }

    public User createUser(String email, String password, String name, int phone, String street, String town, int zipcode) throws UserException
    {
        User user = new User(phone, email, password, "customer", name, street, town, zipcode);
        userMapper.createUser(user);
        return user;
    }

    public User getUser(int userId) throws UserException {

        return userMapper.getUser(userId);
    }

}
