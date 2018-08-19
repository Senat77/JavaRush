package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class FakeModel extends UserServiceImpl implements Model
{
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    @Override
    public void loadUsers()
    {
        List<User> tempList = new ArrayList<>();
        tempList.add(new User("Иванов Иван",1,10));
        tempList.add(new User("Сидоров Сидор",2,15));
        tempList.add(new User("Петров Петр",3,20));
        modelData.setUsers(tempList);
    }

    @Override
    public void loadDeletedUsers()
    {
        throw new UnsupportedOperationException();
        /*
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
        */
    }

    @Override
    public void loadUserById(long userId)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public ModelData getModelData()
    {
        return modelData;
    }

    @Override
    public void changeUserData(String name, long id, int level)
    {
        throw new UnsupportedOperationException();
    }
}
