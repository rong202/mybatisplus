package com.hbj.mybatisplus.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbj.mybatisplus.dao.GirlMapper;
import com.hbj.mybatisplus.dao.UserMapper;
import com.hbj.mybatisplus.model.PageResult;
import com.hbj.mybatisplus.pojo.Girl;
import com.hbj.mybatisplus.pojo.User;
import com.hbj.mybatisplus.service.IGirlServic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GirlServiceImpl  implements IGirlServic {
    @Resource
    private GirlMapper girlMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public PageResult<List<Girl>> findAllPaging(Girl girl) {
        //PageHelper.startPage(girl.getPage(), girl.getRows());
        Page<Object> objectPage = new Page<>(1, 2);
        List<Girl> allPaging = girlMapper.findAllPaging(girl);
       // objectPage.;
        //return new PageResult<>(of.getTotal(), of.getList());
        return null;
    }

    @Override
    public String a(Girl girl) {
        for (int i=0;i<10;i++){
            log.info(i+"");
        }

        List<Girl> girls = girlMapper.selectList(null);
        log.info(girls.toString());
        girls.forEach(e->{
            e.getName();
            e.getId();
        });
        Set<Integer> collect = girls.stream().map(Girl::getId).collect(Collectors.toSet());
        log.info(collect.toString());
        List<Girl> girl9 = girls.stream().sorted(Comparator.comparing(e -> e.getId())).collect(Collectors.toList());
        log.info(girl9.toString());
       // List<User> users = userMapper.selectList(null);
      //  log.info("-----------"+users.toString());
        return "aaa";
    }





}
