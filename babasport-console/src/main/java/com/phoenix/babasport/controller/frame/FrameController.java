package com.phoenix.babasport.controller.frame;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by WuDi on 2017-4-25.
 */
@Controller
@RequestMapping("/frame")
public class FrameController {
  @RequestMapping("/product_main.do")
  public String main(){
    return "frame/product_main";
  }
  @RequestMapping("/product_left.do")
  public String left(){
    return "frame/product_left";
  }
  @RequestMapping("/list.do")
  public String list(){
    return "product/list";
  }
}
