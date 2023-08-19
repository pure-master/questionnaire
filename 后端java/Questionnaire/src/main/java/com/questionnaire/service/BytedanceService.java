package com.questionnaire.service;

import com.questionnaire.pojo.Bytedance;
import com.questionnaire.pojo.PageBean;

import java.util.List;

public interface BytedanceService {

    PageBean page(Integer page, Integer pageSize);

    List<Bytedance> list();

    void delete(Integer id);

    void add(Bytedance bytedance);

    Bytedance search(Integer id);

    void update(Bytedance bytedance);

}