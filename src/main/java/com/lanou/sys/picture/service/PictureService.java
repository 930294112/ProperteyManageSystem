package com.lanou.sys.picture.service;

import com.github.pagehelper.PageInfo;
import com.lanou.sys.picture.bean.Picture;

/**
 * Created by dllo on 17/12/13.
 */
public interface PictureService {
    PageInfo<Picture> findAllPicture(Integer pageNum, Integer pageSize);

    int save(Picture picture);
}
