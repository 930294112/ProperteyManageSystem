package com.lanou.sys.tags.controller;

import com.lanou.sys.tags.bean.Tags;
import com.lanou.sys.tags.service.TagsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/12/14.
 */
@Controller
public class TagsController {
    @Resource
    private TagsService tagsService;
    @ResponseBody
    @RequestMapping(value = "/findAllTags")
    public List<Tags> findAllTags(){
        List<Tags> tagsList = tagsService.findAll();
        return tagsList;
    }
}
