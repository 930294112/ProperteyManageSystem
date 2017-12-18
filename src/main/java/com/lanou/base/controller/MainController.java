package com.lanou.base.controller;

import com.lanou.sys.user.bean.User;
import com.lanou.util.AjaxResult;
import com.lanou.util.VerifyCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by dllo on 17/12/4.
 */
@Controller
public class MainController {
    @RequestMapping(value = "/index")
    public String mainPage() {
        return "index";
    }

//    @RequestMapping(value = "/login")
//    public String loginPage() {
//        return "login";
//    }

    @RequestMapping(value = "/welcome")
    public String welcome() {
        return "welcome";
    }


    @RequestMapping(value = "/article-list")
    public String article_list() {
        return "article/article-list";
    }


//    @RequestMapping(value = "/picture-list")
//    public String picture_list() {
//        return "picture/picture-list";
//    }
//
//    @RequestMapping(value = "/picture-add")
//    public String picture_add() {
//        return "picture/picture-add";
//    }


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
//    @RequestMapping(value = "/admin-role")
//    public String admin_role() {
//        return "admin/admin-role";
//    }

//    @RequestMapping(value = "/admin-permission")
//    public String admin_permission() {
//        return "admin/admin-permission";
//    }

//    @RequestMapping(value = "/admin-list")
//    public String admin_list() {
//        return "admin/admin-list";
//    }


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

    //定位到登录
    @RequestMapping(value = "/login")
    public String loginPage() {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            SecurityUtils.getSubject().logout();
        }
        return "login";
    }

    @RequestMapping(value = "/getVerifyCode")
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        VerifyCode verifyCode = new VerifyCode();
        BufferedImage image = verifyCode.getImage();
        request.getSession().setAttribute("verifyCode", verifyCode.getText());
        VerifyCode.output(image, response.getOutputStream());

    }

    @ResponseBody
    @RequestMapping("/checkVerifyCode")
    public AjaxResult checkVerifyCode(@RequestParam("code") String code, HttpServletRequest request) {
        AjaxResult ajaxResult = new AjaxResult();
        String verifyCode = (String) request.getSession().getAttribute("verifyCode");
        if (!verifyCode.equalsIgnoreCase(code)) {
            ajaxResult.setCount(1);
        }
        return ajaxResult;
    }

    @ResponseBody
    @RequestMapping(value = "/loginsubmit")
    public AjaxResult<User> loginsubmit(User user, HttpServletRequest request, HttpSession session) throws Exception {
        AjaxResult<User> result = new AjaxResult<User>();
        //如果在shirospring的配置文件中,配置了表单认证过滤器,那么在这个方法中只需要处理异常即可
        String exClassName = (String) request.getAttribute("shiroLoginFailure");
        if (UnknownAccountException.class.getName().equals(exClassName)) {
            result.setCount(1);
            result.setMessage("账号不存在");
        } else if (IncorrectCredentialsException.class.getName().equals(exClassName)) {
            result.setCount(1);
            result.setMessage("密码错误");
        }

        return result;


    }


}
