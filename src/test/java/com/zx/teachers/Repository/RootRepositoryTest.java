package com.zx.teachers.Repository;

import com.zx.teachers.Entity.Root;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}