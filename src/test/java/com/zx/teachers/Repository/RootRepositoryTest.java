package com.zx.teachers.Repository;

import com.zx.teachers.Entity.Root;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RootRepositoryTest {

    @Autowired
    private RootRepository rootRepository;

    @Test
    public void findById() {
        Root root = rootRepository.findById(1);
        System.out.println(root);
    }

    @Test
    public void saveRoot() {
        Root root = new Root();
        root.setAdminName("zx2");
        root.setAdminPassword("123321");
        root.setCreateTime(new Date());
        root.setUpdateTime(new Date());
        rootRepository.save(root);
//        System.out.println(root1);
    }
}