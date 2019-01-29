package com.zx.teachers.Controller;

import com.zx.teachers.Entity.Video;
import com.zx.teachers.Service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @RequestMapping("/all")
    @ResponseBody
    public List<Video> getAll(){
        return videoService.getAll();
    }

    @RequestMapping("/create")
    public String create(Video video) {
        videoService.createVideo(video);
        return "admin/success";
    }

    @RequestMapping("/modify")
    public String modify(Video video) {
        videoService.modifyVideo(video);
        return "admin/success";
    }
}
