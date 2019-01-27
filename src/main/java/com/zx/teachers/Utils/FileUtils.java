package com.zx.teachers.Utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;
import java.util.Random;

@Slf4j
public class FileUtils {

    public static String saveUserImg(MultipartFile file) throws IOException {

        File outfile = null;
        try {
            BufferedOutputStream out = null;
            String filename = createRandomName() + "." + file.getOriginalFilename().split("[.]")[1];
            outfile = new File(createRandomPath(), filename);
            log.info(outfile.getName());
            out = new BufferedOutputStream(new FileOutputStream(outfile));
            System.out.println(file.getName());
            out.write(file.getBytes());
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] strings = outfile.getCanonicalPath().split("static");
        return outfile.getCanonicalPath().split("static")[1];
//        return outfile.getPath();
    }

    /**
     * 返回文件保存路径，如果路径文件夹存在，则返回路径，如果不存在，则创建路径
     * @return
     */
    public static File createRandomPath() throws FileNotFoundException {

        File file  = new File(ResourceUtils.getURL("classpath:").getPath() + "/static/teacherFiles/Imges");
        if (!file.exists()){
            file.mkdirs();
        }
        return file;
    }

    /**
     * 生成随机文件名
     * @return
     */
    public static String createRandomName() {
        Long pre = new Date().getTime();
        Random random = new Random(new Date().getTime());
        Long suf = random.nextLong();
        String name = String.valueOf(pre) + String.valueOf(suf);
        return name;
    }

}
