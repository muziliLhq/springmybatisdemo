package com.entor.mybatisdemo;

import com.entor.mybatisdemo.mapper.NoticeMapper;
import com.entor.mybatisdemo.po.Notice;
import com.entor.mybatisdemo.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class NoticeTest {

    @Resource
    private  NoticeMapper noticeMapper;

    @Test
    public  void testGetById() {
        System.out.println(noticeMapper.getById(1).getContent());
    }

    @Test
    public void testInsertNotice(){
        Notice notice = new Notice();
        notice.setContent("douyinshipin");
        User user = new User();
        user.setId(1);
        notice.setUser(user);

        System.out.println(noticeMapper.save(notice));
    }

    @Test
    public void testDeleteNotice(){
        System.out.println(noticeMapper.deleteById(1));
    }

    @Test
    public  void testUpdateNotice(){
        Notice notice = new Notice();
        notice.setId(2);
        notice.setTitle("weixin");

        System.out.println(noticeMapper.update(notice));
    }
    /*private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        this.sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testGetById() {
        NoticeMapper noticeMapper = sqlSessionFactory.openSession().getMapper(NoticeMapper.class);
        System.out.println(noticeMapper.getById(1));

      *//*  SqlSession sqlSession = sqlSessionFactory.openSession();
        NoticeMapper noticeMapper = sqlSession.getMapper(NoticeMapper.class);
        System.out.println(noticeMapper.getById(1));*//*
    }*/
}
