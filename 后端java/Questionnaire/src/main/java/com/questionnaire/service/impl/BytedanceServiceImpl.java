package com.questionnaire.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.questionnaire.mapper.BytedanceMapper;
import com.questionnaire.mapper.UsersMapper;
import com.questionnaire.pojo.Bytedance;
import com.questionnaire.pojo.PageBean;
import com.questionnaire.service.BytedanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BytedanceServiceImpl implements BytedanceService {

    @Autowired
    private BytedanceMapper bytedanceMapper;
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Bytedance> bytedanceList =bytedanceMapper.list();
        Page<Bytedance> p =(Page<Bytedance>) bytedanceList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public List<Bytedance> list() {
        return bytedanceMapper.list();
    }

    @Override
    public void delete(Integer id) {
        bytedanceMapper.deleteById(id);
        usersMapper.deleteId(id);
    }

    @Override
    public void add(Bytedance bytedance){
        bytedanceMapper.insert(bytedance);
        usersMapper.setId(bytedanceMapper.getId(),bytedance.getUsername());
    }

    @Override
    public Bytedance search(Integer id) {
        return bytedanceMapper.search(id);
    }

    @Override
    public void update(Bytedance bytedance) {

        bytedanceMapper.update(bytedance);
    }
}
