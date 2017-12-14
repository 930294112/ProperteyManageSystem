package com.lanou.sys.tags.service.impl;

import com.lanou.sys.tags.bean.Tags;
import com.lanou.sys.tags.mapper.TagsMapper;
import com.lanou.sys.tags.service.TagsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/12/14.
 */
@Service("tagsService")
public class TagsServiceImpl implements TagsService {

    @Resource
    private TagsMapper tagsMapper;

    public List<Tags> findAll() {
        return tagsMapper.findAll();
    }
}
