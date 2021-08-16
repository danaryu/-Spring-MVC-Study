package hello.springmvc.basic.response;


import hello.springmvc.basic.requestmapping.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
//@Controller
//@ResponseBody
@RestController
public class ResponseBodyController {

    @GetMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("OK!");
    }

    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2() throws IOException {
        return new ResponseEntity<>("접수되었습니다.", HttpStatus.ACCEPTED);
    }

    //@ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBodyV3() {
        return "helllooworld";
    }

    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1(){
        HelloData helloData = new HelloData();
        helloData.setAge(20);
        helloData.setUsername("HEEPONG");

        return new ResponseEntity<>(helloData, HttpStatus.ACCEPTED);
    }

    //ResponseBody의 경우 HttpStatus를 선언하지 못하므로, 별도 애노테이션을 통해 응답할 수 있음
    //조건에 따라서 동적으로 변경하기 위해서는, ResponseEntity로 응답을 내려주면 됨
    @ResponseStatus(HttpStatus.ACCEPTED)
    //@ResponseBody
    @GetMapping("/response-body-json-v2")
    public HelloData responseBodyJsonV2(){
        HelloData helloData = new HelloData();
        helloData.setAge(20);
        helloData.setUsername("HEEPONG");

        return helloData;
    }



}
