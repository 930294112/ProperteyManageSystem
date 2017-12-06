package com.lanou.sys.role.service.Impl;

import com.lanou.sys.role.controller.RoleController;
import com.lanou.sys.role.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/12/5.
 */
@Service
public class RoleServiceImpl implements RoleService {


    @Resource
    private RoleController roleController;


}
