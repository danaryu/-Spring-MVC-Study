package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MappingController {

    //URL Mapping
    @RequestMapping(value = {"/hello-basic", "/hello-go"}, method = RequestMethod.GET)
    public String helloBasic() {
        log.info("hellobasic");
        return "okk";
    }

    /**
     * PathVariable 사용(URL경로를 템플릿 화!)
     * 변수명이 같으면 생략 가능
     * @PathVariable("userId") String userId -> @PathVariable userId
     *
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable String userId){
        log.info("MappingPath userId = {}", userId);
        return "okk";
    }

    /**
     * PathVariable 다중 사용
     *
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath2(@PathVariable String userId, @PathVariable int orderId){
        log.info("helllo ={}, world = {}", userId, orderId);
        return "hello";
    }

    /**
     * Accept 헤더 기반 Media Type
     * produces = "text/html"
     * produces = "!text/html"
     * produces = "text/*"
     * produces = "*\/*"
     */
    @PostMapping(value = "/mapping-produce", produces = "application/json")
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }

}

