package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1(){
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!!!");

        return mav;

    }

    //@ResponseBody 하면 문자를 http응답코드로 body에 팍 박힙니다 = @RestController
    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model){
        model.addAttribute("data", "hello ! :) !");

        //view의 논리적인 이름 반환(String)
        return "response/hello";

char[] z = new char[];
z.le
        Map<Character, Integer> map = new HashMap<>();

        map.keySet()

    }

    @RequestMapping("/response/hello")
    public void responseViewV3(Model model){
        model.addAttribute("data", "hello ! :) !");

        //RequestMapping (Controller)의 경로와 return하는 view의 경로가 동일한 경우, return 값 생략 가능
    }
}
