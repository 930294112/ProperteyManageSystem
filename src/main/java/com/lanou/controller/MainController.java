package com.lanou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dllo on 17/12/4.
 */
@Controller
public class MainController {
    @RequestMapping(value = "/")
    public String mainPage() {
        return "index";
    }
    @RequestMapping(value = "/login")
    public String loginPage() {
        return "login";
    }


    /*----------
    |  666   |
    ========== */

    @RequestMapping(value = "/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping(value = "/article-list")
    public String article_list() {
        return "article/article-list";
    }

    @RequestMapping(value = "/picture-list")
    public String picture_list() {
        return "picture/picture-list";
    }

    @RequestMapping(value = "/product-brand")
    public String product_brand() {
        return "product/product-brand";
    }

    @RequestMapping(value = "/product-category")
    public String product_category() {
        return "product/product-category";
    }

    @RequestMapping(value = "/product-list")
    public String product_list() {
        return "product/product-list";
    }

    @RequestMapping(value = "/product-category-add")
    public String product_category_add() {
        return "product/product-category-add";
    }


    @RequestMapping(value = "/feedback-list")
    public String feedback_list() {
        return "feedback-list";
    }

    //会员
    @RequestMapping(value = "/member-list")
    public String member_list() {
        return "member/member-list";
    }

    @RequestMapping(value = "/member-del")
    public String member_del() {
        return "member/member-del";
    }

    @RequestMapping(value = "/member-level")
    public String member_level() {
        return "member/member-level";
    }

    @RequestMapping(value = "/member-scoreoperation")
    public String member_scoreoperation() {
        return "member/member-scoreoperation";
    }

    @RequestMapping(value = "/member-record-browse")
    public String member_record_browse() {
        return "member/member-record-browse";
    }

    @RequestMapping(value = "/member-record-download")
    public String member_record_download() {
        return "member/member-record-download";
    }

    @RequestMapping(value = "/member-record-share")
    public String member_record_share() {
        return "member/member-record-share";

    }
    @RequestMapping(value = "/member-show")
    public String member_show() {
        return "member/member-show";
    }
    @RequestMapping(value = "/member-add")
    public String member_add() {
        return "member/member-add";
    }

    //管理员
    @RequestMapping(value = "/admin-role")
    public String admin_role() {
        return "admin/admin-role";
    }

    @RequestMapping(value = "/admin-permission")
    public String admin_permission() {
        return "admin/admin-permission";
    }

    @RequestMapping(value = "/admin-list")
    public String admin_list() {
        return "admin/admin-list";
    }



    //系统统计
    @RequestMapping(value = "/charts-1")
    public String charts_1() {
        return "charts/charts-1";
    }

    @RequestMapping(value = "/charts-2")
    public String charts_2() {
        return "charts/charts-2";
    }

    @RequestMapping(value = "/charts-3")
    public String charts_3() {
        return "charts/charts-3";
    }

    @RequestMapping(value = "/charts-4")
    public String charts_4() {
        return "charts/charts-4";
    }

    @RequestMapping(value = "/charts-5")
    public String charts_5() {
        return "charts/charts-5";
    }

    @RequestMapping(value = "/charts-6")
    public String charts_6() {
        return "charts/charts-6";
    }

    @RequestMapping(value = "/charts-7")
    public String charts_7() {
        return "charts/charts-7";
    }

    //系统管理
    @RequestMapping(value = "/system-base")
    public String system_base() {
        return "system/system-base";
    }
    @RequestMapping(value = "/system-category")
    public String system_category() {
        return "system/system-category";
    }
    @RequestMapping(value = "/system-data")
    public String system_data() {
        return "system/system-data";
    }
    @RequestMapping(value = "/system-shielding")
    public String system_shielding() {
        return "system/system-shielding";
    }
    @RequestMapping(value = "/system-log")
    public String system_log() {
        return "system/system-log";
    }



}
