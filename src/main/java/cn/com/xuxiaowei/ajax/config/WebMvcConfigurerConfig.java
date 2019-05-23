package cn.com.xuxiaowei.ajax.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Ajax 跨域
 *
 * @author xuxiaowei
 */
@Configuration
public class WebMvcConfigurerConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        // 跨域的路径，可使用 Ant 风格的路径
        // 这里设置为全部路径
        registry.addMapping("/**")

                // 指定跨域的域名
                // 包括以下内容：
                // 协议：http、https
                // 端口：80、443 不用填
                .allowedOrigins(getOrigins())
                // 默认为 GET, HEAD, POST，这里就按默认值即可，如有需要，请自定义
                // 可以为 GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE;
                //<code>.allowedMethods("GET", "HEAD", "POST")</code>

                // 默认为 1800秒（30分钟），这里就按默认值即可，如有需要，请自定义
                // </code>.maxAge(1800)</code>

                // 浏览器是否应将凭据（如Cookie和跨域请求）发送到带注释的端点。
                // 默认为 false
                .allowCredentials(true);

    }

    /**
     * 指定域，需要提供协议、端口
     * <p>
     * 1    ：http
     * 2    ：https
     * 3    ：http、https
     */
    public static String[] getOrigins() {

        Map<String, Integer> map = new HashMap<>(10);

        map.put("xuxiaowei.com.cn:81", 3);
        map.put("xuxiaowei.com.cn:82", 3);

        map.put("xuxiaowei.com.cn", 3);
        map.put("www.xuxiaowei.com.cn", 3);
        map.put("demo.xuxiaowei.com.cn", 3);
        map.put("demo1.xuxiaowei.com.cn", 3);
        map.put("demo2.xuxiaowei.com.cn", 3);

        List<String> list = new ArrayList<>();

        for (String k : map.keySet()) {
            Integer integer = map.get(k);
            if (integer == 1) {
                list.add("http://" + k);
            } else if (integer == 2) {
                list.add("https://" + k);
            } else if (integer == 3) {
                list.add("http://" + k);
                list.add("https://" + k);
            }
        }

        return list.toArray(new String[]{});
    }

}
