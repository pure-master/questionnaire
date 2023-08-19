package com.questionnaire.service;

import com.questionnaire.pojo.Users;


public interface UsersService {

    boolean isUnique(Users users);

    void addUser(Users users);

    Users logInfo(Users users);

    Integer search(String username);

}
