package cn.com.xuxiaowei.ajax.controller;

import cn.com.xuxiaowei.ajax.config.WebMvcConfigurerConfig;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 跨域请求 RestController
 *
 * @author xuxiaowei
 */
@RestController
public class OriginRestController {

    /**
     * 接收跨域请求
     */
    @RequestMapping("/origin.do")
    public Map<String, Object> index(HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> map = new HashMap<>(4);
        Map<String, Object> data = new HashMap<>(4);
        map.put("data", data);

        map.put("code", 0);
        map.put("msg", "跨域请求成功");

        return map;
    }

}
