package com.questionnaire.service.impl;

import com.questionnaire.mapper.UsersMapper;
import com.questionnaire.pojo.Users;
import com.questionnaire.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public boolean isUnique(Users users){
        return(null==usersMapper.isUnique(users.getUsername()));
    }

    @Override
    public void addUser(Users users){
        usersMapper.insert(users);
    }

    @Override
    public Users logInfo(Users users) {
        return usersMapper.logInfo(users);
    }

    @Override
    public Integer search(String username) {
        return usersMapper.search(username);
    }


}

