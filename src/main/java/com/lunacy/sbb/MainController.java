package com.lunacy.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// @Controller : MainController 클래스는 스프링부트의 컨트롤러가 된다
public class MainController {

  @GetMapping("/sbb")
//  @GetMapping : 요청된 URL 과의 매핑을 담당
  @ResponseBody
//  @ResponseBody : URL 요청에 대한 응답으로 문자열을 리턴하라는 의미
  public String index() {
    return "안녕하세요 sbb에 오신것을 환영합니다.";
  }

  @GetMapping("/")
  public String root() {
    return "redirect:/question/list";
  }
}
