package com.zx.teachers.Repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VideoRepositoryTest {

    @Autowired
    private VideoRepository videoRepository;

    @Test
    public void getall(){
        System.out.println(videoRepository.findAll());
    }
}