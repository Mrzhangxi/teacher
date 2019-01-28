package com.zx.teachers.Service.Impl;

import com.zx.teachers.Entity.Video;
import com.zx.teachers.Repository.VideoRepository;
import com.zx.teachers.Service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public List<Video> getAll() {
        return null;
    }

    @Override
    public Video createVideo(Video video) {
        return null;
    }

    @Override
    public Video modifyVideo(Video video) {
        return null;
    }
}
