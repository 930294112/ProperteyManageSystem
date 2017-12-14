package com.lanou.sys.picture.mapper;

import com.lanou.sys.picture.bean.Picture;

import java.util.List;

/**
 * Created by dllo on 17/12/13.
 */
public interface PictureMapper {
    List<Picture> findAll();

    int save(Picture picture);
}
