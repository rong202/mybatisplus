package com.hbj.mybatisplus.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.hbj.mybatisplus.pojo.Girl;
import com.hbj.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 女孩 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2021-04-02
 */
@Mapper
public interface GirlMapper extends BaseMapper<Girl> {

    List<Girl> findAllPaging(@Param("girl") Girl girl);

    List<Girl> findAllGirl(@Param("stringList") List<String> stringList);
    @Select("select * from girl")
    List<Girl> getAll(@Param(Constants.WRAPPER) Wrapper wrapper);

    void update(QueryWrapper<Girl> id);
}
