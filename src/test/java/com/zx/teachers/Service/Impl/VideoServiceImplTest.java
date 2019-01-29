package com.zx.teachers.Service.Impl;

import com.zx.teachers.Entity.Video;
import com.zx.teachers.Service.VideoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VideoServiceImplTest {

    @Autowired
    private VideoService videoService;

    @Test
    public void getall() {
        System.out.println(videoService.getAll());
    }

    @Test
    public void createVideo() {
        Video video = new Video();
        video.setId(2);
        video.setVideoName("Java从入门到放弃 一");
        video.setVideoHref("/");
        video.setLesssonId(1);
        System.out.println(videoService.createVideo(video));

    }

    @Test
    public void modifyVideo() {
        Video video = new Video();
        video.setId(1);
        video.setVideoName("Java从入门到放弃 入门篇");
        video.setVideoHref("/");
        video.setLesssonId(1);
        System.out.println(videoService.modifyVideo(video));
    }
}