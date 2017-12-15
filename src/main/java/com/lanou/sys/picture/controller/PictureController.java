package com.lanou.sys.picture.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.sys.picture.bean.Picture;
import com.lanou.sys.picture.service.PictureService;
import com.lanou.util.AjaxResult;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;


/**
 * Created by dllo on 17/12/13.
 */
@Controller
public class PictureController {

    @Resource
    private PictureService pictureService;

    @RequestMapping(value = "/picture-list")
    public String picture_list() {
        return "picture/picture-list";
    }


    /**
     * 查询所有的图片
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findAllPicture")
    public PageInfo<Picture> findAllPicture(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        AjaxResult<Picture> result = new AjaxResult<Picture>();
        PageInfo<Picture> pageInfo = pictureService.findAllPicture(pageNum, pageSize);
        return pageInfo;
    }


    /**
     * 调到增加的界面
     * @return
     */
    @RequestMapping(value = "picture/picture-add")
    public String picture_add() {
        return "picture/picture-add";
    }

    @Resource
    private HttpServletRequest request;

    /**
     * 保存图片
     * @param picture
     * @param file
     * @return
     */
    @RequestMapping(value = "/picture_save")
    public String picture_save(Picture picture, @RequestParam("file") MultipartFile file) {
        String type = null;
            if (file != null) {
            String fileName = file.getOriginalFilename();
                type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            if (type != null) {
                if (("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase()))) {
                   //获取真实路径
                    String realPath = request.getSession().getServletContext().getRealPath("/temp");
                    File newPath = new File(realPath);
                    if (!newPath.exists()){
                        newPath.mkdirs();
                    }

                    System.out.println(newPath);
                    //给名字加上当前的时间 避免名字重复
                    String trueFileName = String.valueOf(System.currentTimeMillis() + fileName);
                    File desPath = new File(newPath,trueFileName);

                    try {
                        //保存图片
                        FileUtils.writeByteArrayToFile(desPath,file.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //保存图片的路径到数据中
                    picture.setSrc("temp/" + trueFileName);

                }
            }
        }
        picture.setCreate_time(new Timestamp(System.currentTimeMillis()));
        picture.setUpdate_time(new Timestamp(System.currentTimeMillis()));
        picture.setState(1);
        System.out.println(picture);
        pictureService.save(picture);
        return "redirect:picture-list";
    }


}
