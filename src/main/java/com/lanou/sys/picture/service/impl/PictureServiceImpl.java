package com.lanou.sys.picture.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.sys.picture.bean.Picture;
import com.lanou.sys.picture.mapper.PictureMapper;
import com.lanou.sys.picture.service.PictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/12/13.
 */
@Service("pictureService")
public class PictureServiceImpl implements PictureService {
    @Resource
    private PictureMapper pictureMapper;

    public PageInfo<Picture> findAllPicture(Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 :pageNum;
        pageSize = pageSize == null ? 3 :pageSize;
        PageHelper.startPage(pageNum,pageSize);
        List<Picture> pictures = pictureMapper.findAll();
        PageInfo<Picture> pageInfo = new PageInfo<Picture>(pictures);
        return pageInfo;

    }

    public int save(Picture picture) {
        return pictureMapper.save(picture);
    }
}
