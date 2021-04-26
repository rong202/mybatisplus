package com.hbj.mybatisplus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbj.mybatisplus.dao.GirlMapper;
import com.hbj.mybatisplus.dao.UserMapper;
import com.hbj.mybatisplus.model.PageResult;
import com.hbj.mybatisplus.pojo.Girl;
import com.hbj.mybatisplus.pojo.User;
import com.hbj.mybatisplus.service.IGirlService;
import com.hbj.mybatisplus.service.UserService;
import com.oracle.tools.packager.Log;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.management.Query;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 女孩 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-04-02
 */
@RestController
@RequestMapping("/girl")
public class GirlController {
    @Autowired
    private IGirlService GirlService;
    @Resource
    private UserService userService;
    @Resource
    private GirlMapper girlMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private IGirlService getGirlService;

    @GetMapping("findAll")
    public List<User> findAll() {
        /**
         * userService.list() 需要重写，否则查询不到数据库数据
         * 数据库数据还是通过Mapper 来实
         */
        List<User> list = userService.list();
        return list;
    }

    @GetMapping("findAll1")
    public List<User> findAll1() {
        List<User> list = userMapper.selectList(null);
        return list;
    }

    @GetMapping("findAllPaging")
    public void findAllPaging(Girl girl) {
        Page<Girl> girlPage = new Page<Girl>(1, 2);
        QueryWrapper<Girl> id = new QueryWrapper<Girl>().orderByAsc("id");
        girlMapper.selectPage(girlPage, id);
        girlPage.getRecords().forEach(System.out::println);

    }

    @ApiOperation("hello接口")
    @PostMapping("hello")
    public String hello(@RequestParam String str) {
        System.out.println(str);
        return str;
    }

    @GetMapping("gethello")
    public String hello1(@RequestParam String str) {
        System.out.println(str);
        return str;
    }

    @GetMapping("gethello2")

    public String hello2(@RequestParam List<String> str) {
        System.out.println(str);
        String s = str.get(0);
        return s;
    }

    @ApiOperation("user接口")
    @PostMapping("user")
    public User user(User user) {
        return user;
    }

    @PostMapping("user1")
    public String user1(@RequestParam String a, User user) {
        String id = user.getId();
        String name = user.getName();


        return id + " ----- " + name;
    }

    @PostMapping("girl")
    public String girl(@RequestParam List<String> stringList) {

        List<Girl> allGirl = girlMapper.findAllGirl(stringList);
        StringBuilder stringBuilder = new StringBuilder();
        for (Girl girl : allGirl) {
            stringBuilder.append(girl.getName()).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        String s = stringBuilder + "";
        return s;
    }

    @PostMapping("girl1")
    public List<Girl> girl1(Girl girl) {
        //List<Girl> allGirl = girlMapper.selectList(name);
        List<Girl> all = girlMapper.getAll(null);
        List<Girl> sorted = all.stream().sorted(Comparator.comparing(Girl::getId)).collect(Collectors.toList());
        sorted.forEach(System.out::println);
//1、简化代码，是为了提高自身对语法的掌握能力
        //2.不总结，白干活

      //  all.stream().sorted(Comparator.comparingLong(e->Integer.parseInt(e.getId()))).forEach(
      /*          e->{
                    System.out.println(e.getId());
                }
        );*/

       // all.sort(Comparator.nullsFirst(Comparator.comparing(Girl::getName)));
        all.forEach(System.out::println);
        //all.sort(Comparator.comparing(person -> person.getId()));
        //List<Girl> collect = all.stream().sorted(Comparator.comparing(Girl::getId)).collect(Collectors.toList());

/*
        Map<String, List<Girl>> collect = all.stream().collect(Collectors.groupingBy(Girl::getId));
*/


       // System.out.println(collect);

       // all.sort(Comparator.comparingLong(e-> Integer.parseInt(e.getId())));
        /*List<Girl> a = all.stream().sorted((u1, u2) -> u2.getId().compareTo(u1.getId()))
                .collect(Collectors.toList());*/
/*
        List<Girl> collect1 = collect.entrySet() // 获取entrySet
                .stream() // 将其转化成流
                .map(Map.Entry<String, List<Girl>>::getValue) // MultiValueMap<String, HttpCookie> -> List<HttpCookie>
                .flatMap(List<Girl>::stream)
                .collect(Collectors.toList());// List<HttpCookie> -> HttpCookie
        collect1.sort(Comparator.comparingLong(e-> Integer.parseInt(e.getId())));
        System.out.println(collect1);*/
        return all;
    }

    @PostMapping("girl2")
    public List<Girl> girl2(Girl girl) {
        QueryWrapper<Girl> name = new QueryWrapper<Girl>().eq("name", "o");
        List<Girl> all = girlMapper.selectList(name);
        return all;
    }

    @PostMapping("girl3")
    public List<Girl> girl3(Girl girl) {
        QueryWrapper<Girl> name = new QueryWrapper<Girl>().groupBy("name", "id").orderByAsc("id");
        List<Girl> all = girlMapper.selectList(name);
        return all;
    }

    @PostMapping("girl4")
    public String girl4(@RequestParam List<String> stringList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringList.forEach(e ->
                stringBuilder.append(e).append(",")
        );
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        String s = stringBuilder.toString();

        QueryWrapper<Girl> id = new QueryWrapper<Girl>().inSql("id", s);
        List<Girl> allGirl = girlMapper.selectBatchIds(stringList);


        return s;
    }

    @GetMapping("girl5")
    public String girl5(@RequestParam List<String> stringList) {


        List<Girl> allGirl = girlMapper.selectBatchIds(stringList);
        allGirl.forEach(
                E -> {
                    System.out.println(E.getName());
                    System.out.println(E.getBirthday());
                }
        );
        Map<Integer, List<Girl>> collect = allGirl.stream().sorted(Comparator.comparing(girl ->
        {
            return girl.getId();
        })).collect(Collectors.groupingBy(e -> e.getId()));
       // collect.entrySet().stream(Map.Entry.).flatMap();


        return null;
    }

    @GetMapping("girl6")
    public void girl6() {
      /*  List<Integer> integers = Arrays.asList(6, 5, 4, 3, 2, 1, 11);
        integers.stream().sorted(Comparator.comparingInt(Integer::intValue)).forEach(e->{
            System.out.println(e);
        });*/
        String a = "false";
        Optional<String> a1 = Optional.ofNullable(a);


        Log.info(a1.toString());
        List<Girl> girls = girlMapper.selectList(null);
        boolean present = Optional.ofNullable(girls).isPresent();
        Optional.ofNullable(girls).get();
        List<Girl> sorted = new ArrayList<>();
        for (Girl girl : girls) {
            sorted.add(girl);
        }
      //  girls.stream().sorted(e -> Comparator.comparing(e.getName(), Comparator.nullsFirst(StringBuilder::compareTo)));

        girls.stream().sorted(Comparator.comparing(l -> l.getId(), Comparator.nullsLast(Integer::compareTo))).findFirst().get();
        girls.forEach(System.out::println);
       /* List<Girl> collect1 = girls.stream().filter(e ->
              e.getId() != null).sorted(Comparator.comparing(girl ->
        {
            return girl.getId();
        })).collect(Collectors.toList());*/

        /*for (Girl e1 : collect1) {
            System.out.println(e1.getId());
        }*/
       Log.info("--------------------------");
       /* girls.stream().filter(e -> e.getZ() != null && e.getId() != null).sorted(Comparator.comparing(
                Girl::getName
        ));*/
/*
        Map<String, List<Girl>> collect = girls.stream()
                .sorted(Comparator.comparing(Girl::getId))
                .collect(Collectors.groupingBy(Girl::getId));*/


       /* collect.entrySet() // 获取entrySet
                .stream() // 将其转化成流
                .map(Map.Entry<String, List<Girl>>::getValue) // MultiValueMap<String, HttpCookie> -> List<HttpCookie>
                .flatMap(List<Girl>::stream) // List<HttpCookie> -> HttpCookie
                .forEach(girl -> {
                    System.out.println(girl.getId());
                })*/
        ; // 遍历，存入内容

        Function<Girl, List<Object>> keyExtractor = wr ->
                Arrays.<Object>asList(wr.getId(), wr.getName(), wr.getBirthday());
/*
            girls.stream().collect(
                Collectors.groupingBy(keyExtractor)).entrySet().stream()
                    .map(Map.Entry<String, List<Girl>>::getValue)
                    .flatMap(List<Girl>::stream)
                    .collect(Collectors.toList());*/



        Map<String, List<Girl>> collect = girls.stream().collect(Collectors.groupingBy(e ->
                fetchGroupKey(e)
        ));

        List<Girl> collect1 = collect.entrySet().stream().map(Map.Entry<String, List<Girl>>::getValue).flatMap(List<Girl>::stream).collect(Collectors.toList());
        collect1.forEach(
                System.out::println
        );
        System.out.println("==================================================");
        List<Girl> collect2 = collect1.stream().sorted(Comparator.comparing(Girl::getId)).collect(Collectors.toList());
        collect2.forEach(
                System.out::println
        );
    }
    private static String fetchGroupKey(Girl g){
        return g.getId() +"#"+ g.getName();
    }
    @GetMapping("test")
    public String Test(Girl girl){
        String a = getGirlService.a(girl);
        return a;
    }

}