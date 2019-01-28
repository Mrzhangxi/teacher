package com.zx.teachers.Service;

import com.zx.teachers.Entity.Video;

import java.util.List;

public interface VideoService {

    List<Video> getAll();

    Video createVideo(Video video);

    Video modifyVideo(Video video);


}
