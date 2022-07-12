package com.atguigu.mybatis_plus;

import com.atguigu.mybatis_plus.entity.User;
import com.atguigu.mybatis_plus.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    //添加
    @Test
    public void testAdd() {
        User user = new User();
        user.setName("zhang3");
        user.setAge(33);
        user.setEmail("zhang3@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setName("zhou8");
        user.setAge(88);
        user.setEmail("zhou8@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void delById() {
        int i = userMapper.deleteById(1546828519823204354L);
        System.out.println("i = " + i);
    }

    @Test
    public void testSelect1() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(users);
    }

    //简单条件查询
    @Test
    public void testSelect2() {
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("name", "Jack");
        columnMap.put("age", 20);
        List<User> users = userMapper.selectByMap(columnMap);
        System.out.println(users);
    }
    @Test
    public void happyUser(){
        User user = userMapper.selectById(1);
        user.setEmail("test1upup@baomidou.com");
        int update = userMapper.updateById(user);
        System.out.println("update = " + update);

    }

    //分页查询
    @Test
    public void testSelectPage() {
        Page<User> page = new Page(1, 3);
        Page<User> userPage = userMapper.selectPage(page, null);
        //返回对象得到分页所有数据
        long pages = userPage.getPages(); //总页数
        long current = userPage.getCurrent(); //当前页
        List<User> records = userPage.getRecords(); //查询数据集合
        long total = userPage.getTotal(); //总记录数
        boolean hasNext = userPage.hasNext();  //下一页
        boolean hasPrevious = userPage.hasPrevious(); //上一页
        System.out.println(pages);
        System.out.println(current);
        System.out.println(records);
        System.out.println(total);
        System.out.println(hasNext);
        System.out.println(hasPrevious);
    }

    @Test
    public void deledUser() {
        int result = userMapper.deleteBatchIds(Arrays.asList(2,3));
        System.out.println(result);
    }


}
