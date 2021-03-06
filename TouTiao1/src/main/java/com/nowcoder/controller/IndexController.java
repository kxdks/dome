package com.nowcoder.controller;

import com.nowcoder.aspect.LogAspect;
import com.nowcoder.model.User;
import com.nowcoder.service.TouTiaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by Administrator on 2016/6/27.
 */
@Controller
public class IndexController {
    private static  final Logger logger= LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private TouTiaoService toutiaoService;

    @RequestMapping(path={"/","index"},method ={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String index(HttpSession session){
        logger.info("Visit Index");
        return "hello world"+session.getAttribute("msg")
                +"<br> Say:"+toutiaoService.say();

    }

    @RequestMapping(value={"/profile/{groupId}/{userId}"})
    @ResponseBody
    public String profile(@PathVariable("groupId") String groupId,
                          @PathVariable("userId") int userId,
                          @RequestParam(value="type", defaultValue="1") int type,
                          @RequestParam(value="key", defaultValue = "nowcoder") String key){
        return String.format("{%s},{%d},{%d},{%s}",groupId,userId,type,key);
    }

    @RequestMapping(value={"/vm"})
    public String news(Model model ){
        model.addAttribute("value1","vvv");
        List<String> colors = Arrays.asList(new String[] {"red","green","blue"});
        Map<String,String> map = new HashMap<String,String>();
        for (int i = 0; i <4 ; i++) {
            map.put(String.valueOf(i),String.valueOf(i*i));
        }
        model.addAttribute("colors",colors);
        model.addAttribute("map",map);
        model.addAttribute("user",new User("Tom"));

        return "news";
    }

    @RequestMapping(value = {"/request"})
    @ResponseBody
    public String request(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpSession ression){
        StringBuilder sb = new StringBuilder();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            sb.append(name + ":" + request.getHeader(name) + "<br>");
        }

        for (Cookie cookie:request.getCookies()){
            sb.append("Cookie:");
            sb.append(cookie.getName());
            sb.append(":");
            sb.append(cookie.getValue());
            sb.append("<br>");
        }

        sb.append("请求方法："+request.getMethod()+"<br>");
        sb.append("URI相关："+request.getPathInfo()+"<br>");
        sb.append("参数"+request.getQueryString()+"<br>");
        sb.append("URI"+request.getRequestURI()+"<br>");
        return sb.toString();
    }


    @RequestMapping(value = {"/response"})
    @ResponseBody
    public String response(@CookieValue(value="nowcoderid",defaultValue = "a") String nowcoderid,
                           @RequestParam(value="key",defaultValue = "key") String key,
                           @RequestParam(value = "value", defaultValue = "value") String value,
                           HttpServletResponse response){
        response.addCookie(new Cookie(key,value));
        response.addHeader(key,value);
        return "nowcoder id from Cookie:" +nowcoderid;
    }



    @RequestMapping("/redirect/{code}")
    public String redirect(@PathVariable("code") int code,
                           HttpSession session){
        /*
        RedirectView red = new RedirectView("/",true);
        if(code ==301){
            red.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
        }
        return red;*/
        session.setAttribute("msg","Jump from redirect.");
        return "redirect:/";
    }

    @RequestMapping("/admin")
    @ResponseBody
    public  String admin(@RequestParam(value="key",required= false) String key){
        if("admin".equals(key)){
            return "hello main";
        }
        throw new IllegalArgumentException("key错误");
    }

    @ExceptionHandler()
    @ResponseBody
    public String error(Exception e){
        return "error:"+e.getMessage();
    }
}
