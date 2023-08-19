package com.questionnaire.controller;


import com.questionnaire.pojo.Result;
import com.questionnaire.pojo.Users;
import com.questionnaire.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j

@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    //注册
    @PostMapping("/register")
    public Result add(@RequestBody Users users){
        if(usersService.isUnique(users)){
            log.info("新增账户{}",users);
            usersService.addUser(users);
            return Result.success();
        }else
            return Result.error("用户名已存在");
    }
    //登录
    @PostMapping("/login")
    public Result login(@RequestBody Users users) {
        Users userInfo=usersService.logInfo(users);
        if(null==userInfo){
            return Result.error("用户名或密码错误");
        }
        else if(null==userInfo.getQuestionnaireid()){
            return Result.success();
        }
        else{
            return Result.success(userInfo.getQuestionnaireid());
        }
    }

    @GetMapping("/{username}")
    public Result getIdByUsername(@PathVariable String username){
        log.info("根据username查询questionnaireid {}",username);
        Integer questionnaireid=usersService.search(username);
        return Result.success(questionnaireid);
    }
}
