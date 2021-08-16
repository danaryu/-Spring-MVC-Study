package hello.springmvc.basic.request;

import hello.springmvc.basic.requestmapping.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParam(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username = {}, age = {}", username, age);

        //IOException 발생할 수 있으므로, getWriter를 이용해서 써준다.
        response.getWriter().write("ok");

    }

    //view조회를 진행하지 않고, 바로 http body에 메세지를 담아서 보낸다.
    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge
    ){
        log.info("username = {}, age = {}", memberName, memberAge);

        return "OKKKKKKKay";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age
    ){
        log.info("username = {}, age = {}", username, age);

        return "OKKKKKKKay";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age){
        log.info("username = {}, age = {}", username, age);

        return "OKKKKKKKay v4";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = false) String username,
            @RequestParam int age) {
        log.info("username = {}, age = {}", username, age);

        return "OKKKKKKKay";
    }

    @ResponseBody
    @RequestMapping("model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){
/*
       HelloData helloData = new HelloData();
        helloData.setUsername(username);
        helloData.setAge(age);
*/
        log.info("username = {}, age = {}",  helloData.getUsername(), helloData.getAge());
        log.info("helloData={}", helloData);

        return "okkk";
    }

    @ResponseBody
    @RequestMapping("model-attribute-v2")
    public String modelAttributeV2(HelloData helloData){
/*
       HelloData helloData = new HelloData();
        helloData.setUsername(username);
        helloData.setAge(age);
*/
        log.info("username = {}, age = {}",  helloData.getUsername(), helloData.getAge());
        log.info("helloData={}", helloData);

        return "okkk";
    }


}

