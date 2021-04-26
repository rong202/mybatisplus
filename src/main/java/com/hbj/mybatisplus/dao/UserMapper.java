package com.hbj.mybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hbj.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
