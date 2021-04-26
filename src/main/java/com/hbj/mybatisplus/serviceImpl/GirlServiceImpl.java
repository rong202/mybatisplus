package com.hbj.mybatisplus.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbj.mybatisplus.dao.GirlMapper;
import com.hbj.mybatisplus.dao.UserMapper;
import com.hbj.mybatisplus.model.PageResult;
import com.hbj.mybatisplus.pojo.Girl;
import com.hbj.mybatisplus.pojo.User;
import com.hbj.mybatisplus.service.IGirlService;
import com.oracle.tools.packager.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.comparator.Comparators;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GirlServiceImpl  implements IGirlService {
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
        List<User> users = userMapper.selectList(null);
        log.info(users.toString());
        return "aaa";
    }


    @Override
    public boolean save(Girl entity) {
        return false;
    }

    @Override
    public boolean saveBatch(Collection<Girl> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Girl> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean removeById(Serializable id) {
        return false;
    }

    @Override
    public boolean removeByMap(Map<String, Object> columnMap) {
        return false;
    }

    @Override
    public boolean remove(Wrapper<Girl> queryWrapper) {
        return false;
    }


    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        return false;
    }

    @Override
    public boolean updateById(Girl entity) {
        return false;
    }

    @Override
    public boolean update(Girl entity, Wrapper<Girl> updateWrapper) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Girl> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Girl entity) {
        return false;
    }

    @Override
    public Girl getById(Serializable id) {
        return null;
    }

    @Override
    public Collection<Girl> listByIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public Collection<Girl> listByMap(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public Girl getOne(Wrapper<Girl> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<Girl> queryWrapper) {
        return null;
    }

    @Override
    public int count(Wrapper<Girl> queryWrapper) {
        return 0;
    }

    @Override
    public List<Girl> list(Wrapper<Girl> queryWrapper) {
        return null;
    }

    @Override
    public IPage<Girl> page(IPage<Girl> page, Wrapper<Girl> queryWrapper) {
        return null;
    }

    @Override
    public List<Map<String, Object>> listMaps(Wrapper<Girl> queryWrapper) {
        return null;
    }

    @Override
    public <V> List<V> listObjs(Wrapper<Girl> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public IPage<Map<String, Object>> pageMaps(IPage<Girl> page, Wrapper<Girl> queryWrapper) {
        return null;
    }

    @Override
    public BaseMapper<Girl> getBaseMapper() {
        return null;
    }


}
