package com.lanou.sys.album.controller;

import com.lanou.sys.album.bean.Album;
import com.lanou.sys.album.service.AlbumService;
import com.lanou.util.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/12/14.
 */
@Controller
public class AlbumController {
    @Resource
    private AlbumService albumService;

    @ResponseBody
    @RequestMapping(value = "/findAllClassfiy")
    public List<Album> findAllClassfiy(){
        List<Album> albumList = albumService.findAll();

        return albumList;
    }
}
