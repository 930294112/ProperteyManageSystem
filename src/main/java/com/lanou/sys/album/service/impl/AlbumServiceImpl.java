package com.lanou.sys.album.service.impl;

import com.lanou.sys.album.bean.Album;
import com.lanou.sys.album.mapper.AlbumMapper;
import com.lanou.sys.album.service.AlbumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/12/14.
 */
@Service("albumService")
public class AlbumServiceImpl implements AlbumService {
    @Resource
    private AlbumMapper albumMapper;

    public List<Album> findAll() {
        return albumMapper.findAll();
    }
}
