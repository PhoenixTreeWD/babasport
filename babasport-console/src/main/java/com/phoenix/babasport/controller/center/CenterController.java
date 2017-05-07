package com.phoenix.babasport.controller.center;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by WuDi on 2017-4-25.
 */
@Controller
@RequestMapping("/center")
public class CenterController {
  @RequestMapping("/index")
  public String index(){
    return "index";
  }
  @RequestMapping("/top")
  public String top(){
    return "top";
  }
  @RequestMapping("/main")
  public String main(){
    return "main";
  }
  @RequestMapping("/left")
  public String left(){
    return "left";
  }
  @RequestMapping("/right")
  public String right(){
    return "right";
  }
}
