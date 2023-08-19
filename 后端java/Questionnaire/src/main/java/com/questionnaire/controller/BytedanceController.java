package com.questionnaire.controller;

import com.questionnaire.pojo.Bytedance;
import com.questionnaire.pojo.PageBean;
import com.questionnaire.service.BytedanceService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.questionnaire.pojo.Result;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RequestMapping("/bytedance")
public class BytedanceController {

    @Autowired
    private BytedanceService bytedanceService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pageSize){
        log.info("分页查询，参数{},{}",page,pageSize);
        PageBean pageBean=bytedanceService.page(page,pageSize);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除问卷{}",id);
        bytedanceService.delete(id);
        return Result.success();
    }


    @PostMapping
    public Result add(@RequestBody Bytedance bytedance){
        log.info("新增问卷{}",bytedance);
        bytedanceService.add(bytedance);
        return Result.success();
    }


    @GetMapping("/{id}")
    public Result search(@PathVariable Integer id){
        log.info("根据id查询问卷{}",id);
        Bytedance bytedance=bytedanceService.search(id);
        return Result.success(bytedance);
    }


    @PutMapping
    public Result update(@RequestBody Bytedance bytedance){
        log.info("修改问卷{}",bytedance);
        bytedanceService.update(bytedance);
        return Result.success();
    }
}
