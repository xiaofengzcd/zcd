package com.zcd.controller;

/**
 * @author zcd
 * @description:
 * @create 2020/7/1 9:39
 */
import com.zcd.zcdutil.JsonUtilzcd;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
///photo/save_photo
@RestController
@RequestMapping(value = "/photo", method = {RequestMethod.POST})
public class UploadController {


    private String sava_path;


    @RequestMapping(value = "/save_photo", method = {RequestMethod.POST})
    public String addDish(@RequestParam("photos") MultipartFile file, HttpServletRequest request) throws Exception {
        String path = null;// 文件路径
        double fileSize = file.getSize();
        System.out.println("文件的大小是"+ fileSize);

        byte[] sizebyte=file.getBytes();
        System.out.println("文件的byte大小是"+ sizebyte.toString());



        if (file != null) {// 判断上传的文件是否为空
            String type = null;// 文件类型
            String fileName = file.getOriginalFilename();// 文件原名称
            System.out.println("上传的文件原名称:" + fileName);
            // 判断文件类型
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            if (type != null) {// 判断文件类型是否为空

                if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {

                    // 项目在容器中实际发布运行的根路径
                    String realPath = request.getSession().getServletContext().getRealPath("/");
                    // 自定义的文件名称
                    String trueFileName = String.valueOf(System.currentTimeMillis()) + "." + type;
                    // 设置存放图片文件的路径

                    path = sava_path+fileName;
                    System.out.println("存放图片文件的路径:" + path);

                    // 转存文件到指定的路径
                    file.transferTo(new File(path));
                    System.out.println("文件成功上传到指定目录下");

                    return JsonUtilzcd.getJson("文件成功上传到指定目录下");
                }

            } else {
                System.out.println("不是我们想要的文件类型,请按要求重新上传");
                return JsonUtilzcd.getJson("不是我们想要的文件类型,请按要求重新上传");
            }
        } else {
            System.out.println("文件类型为空");
            return JsonUtilzcd.getJson("文件类型为空");
        }

        return JsonUtilzcd.getJson("已经成功上传到指定目录");
    }
}