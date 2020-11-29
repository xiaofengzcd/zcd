package com.zcd.controller;

import com.zcd.zcdutil.JsonUtilzcd;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;


         /**
              * @author zcd
              * @description: description
              * @create 2020/11/29
              */
@RestController
@RequestMapping(value = "/upload", method = {RequestMethod.GET})
public class UploadController {


    private String sava_path ="D:\\qqFile\\1849493899\\FileRecv\\myproject\\src\\main\\resources\\static\\";

   //  http://localhost:8080/maven02_war_exploded/upload/upload_photo
    @RequestMapping(value = "/upload_photo", method = {RequestMethod.GET},produces = "application/json;charset=utf-8")
    public String addPhoto(/*@RequestParam(required = false) MultipartFile multipartFile,*/ HttpServletRequest request) throws Exception {
        String path = null;// 文件路径
        //new一个本地file文件,转成 MultipartFile 类型,以模拟和代替 请求参数
        File file = new File("C:\\Users\\Administrator\\Desktop\\demo.png");
        FileInputStream input = new FileInputStream(file);
        //这里把手动指定要上传的文件,实际情况应为 MultipartFile 类型的请求参数
        MultipartFile multipartFile =new MockMultipartFile("file", file.getName(), "text/plain", IOUtils.toByteArray(input));

        double fileSize = multipartFile.getSize();
        System.out.println("文件的大小是"+ fileSize);
        byte[] sizebyte=multipartFile.getBytes();
        System.out.println("文件的byte大小是"+ sizebyte.toString());
        if (multipartFile != null) {// 判断上传的文件是否为空
            String type = null;// 文件类型
            String fileName = multipartFile.getOriginalFilename();// 文件原名称
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
                    multipartFile.transferTo(new File(path));
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

     //   http://localhost:8080/maven02_war_exploded/upload/upload_file
    @RequestMapping(value = "/upload_file", method = {RequestMethod.GET},produces = "application/json;charset=utf-8")
    public String addFile(/*@RequestParam(required = false) MultipartFile multipartFile,*/ HttpServletRequest request) throws Exception {
        String path = null;// 文件路径
        File file = new File("C:\\Users\\Administrator\\Desktop\\zd.txt");
        FileInputStream input = new FileInputStream(file);
        MultipartFile multipartFile =new MockMultipartFile("file", file.getName(), "text/plain", IOUtils.toByteArray(input));

        double fileSize = multipartFile.getSize();
        System.out.println("文件的大小是"+ fileSize);
        byte[] sizebyte=multipartFile.getBytes();
        System.out.println("文件的byte大小是"+ sizebyte.toString());

        if (multipartFile != null) {// 判断上传的文件是否为空
            String type = null;// 文件类型
            String fileName = multipartFile.getOriginalFilename();// 文件原名称
            System.out.println("上传的文件原名称:" + fileName);
            // 判断文件类型
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            if (type != null) {// 判断文件类型是否为空

                    // 项目在容器中实际发布运行的根路径
                    String realPath = request.getSession().getServletContext().getRealPath("/");
                    // 自定义的文件名称
                    String trueFileName = String.valueOf(System.currentTimeMillis()) + "." + type;
                    // 设置存放图片文件的路径

                    path = sava_path+fileName;
                    System.out.println("存放图片文件的路径:" + path);

                    // 转存文件到指定的路径
                    multipartFile.transferTo(new File(path));
                    System.out.println("文件成功上传到指定目录下");

                    return JsonUtilzcd.getJson("文件成功上传到指定目录下");
            }
        } else {
            System.out.println("文件类型为空");
            return JsonUtilzcd.getJson("文件类型为空");
        }

        return JsonUtilzcd.getJson("已经成功上传到指定目录");
    }




}