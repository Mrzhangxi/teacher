package com.zx.teachers.Controller;

import com.zx.teachers.Entity.Video;
import com.zx.teachers.Service.VideoService;
import com.zx.teachers.Utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public String create(Video video, @RequestParam(value = "videoFile", required = false) MultipartFile file) {
        String videoPath = null;
        System.out.println(video);
        System.out.println(file);
        try {
            videoPath = FileUtils.saveVideo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        video.setVideoHref(videoPath);
        videoService.createVideo(video);
        return "admin/success";
    }

    @RequestMapping("/modify")
    public String modify(Video video) {
        videoService.modifyVideo(video);
        return "admin/success";
    }
}
