package cn.com.xuxiaowei.ajax.controller;

import cn.com.xuxiaowei.ajax.config.WebMvcConfigurerConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 主页 Controller
 *
 * @author xuxiaowei
 */
@Controller
public class IndexController {

    /**
     * 主页
     */
    @RequestMapping("")
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) {

        // 获取 支持跨域的域名
        // 从 Ajax 跨域 配置中获取
        String[] origins = WebMvcConfigurerConfig.getOrigins();

        // 获取完整域名
        String domain = getDomain(request);

        // 转化为 List
        List<String> list = new ArrayList<>(Arrays.asList(origins));

        // Ajax 跨域 是否包含本项目
        // -1：不包含
        int indexOf = list.indexOf(domain);

        if (indexOf == -1) {

            model.addAttribute("origins", false);

        } else {

            // 移除本项目
            list.remove(domain);

            // 跨域的域名 放入页面
            model.addAttribute("origins", list);

        }

        return "index";
    }

    /**
     * 获取完整域名
     */
    private String getDomain(HttpServletRequest request) {

        // URL
        String url = request.getRequestURL().toString();
        int urlLength = url.length();

        // URI
        String uri = request.getRequestURI();
        int uriLength = uri.length();

        return url.substring(0, urlLength - uriLength);
    }

}
