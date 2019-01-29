package com.zx.teachers.Service.Impl;

import com.zx.teachers.Entity.Video;
import com.zx.teachers.Repository.VideoRepository;
import com.zx.teachers.Service.VideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public List<Video> getAll() {
        return videoRepository.findAll();
    }

    @Override
    public Video createVideo(Video video) {

        return videoRepository.save(video);
    }

    @Override
    public Video modifyVideo(Video video) {
        int id = video.getId();
        Video oldVideo = videoRepository.findById(id);
        BeanUtils.copyProperties(video, oldVideo);
        oldVideo.setId(id);
        return videoRepository.save(oldVideo);
    }
}
