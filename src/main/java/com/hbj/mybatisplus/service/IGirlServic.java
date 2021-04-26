package com.hbj.mybatisplus.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hbj.mybatisplus.model.PageResult;
import com.hbj.mybatisplus.pojo.Girl;

import java.util.List;

/**
 * <p>
 * 女孩 服务类
 * </p>
 *
 * @author jobob
 * @since 2021-04-02
 */
public interface IGirlServic {

   PageResult<List<Girl>> findAllPaging(Girl girl);

   String a(Girl girl);
}
