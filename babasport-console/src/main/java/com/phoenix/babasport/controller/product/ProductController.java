package com.phoenix.babasport.controller.product;

import com.phoenix.babasport.pojo.page.Pagination;
import com.phoenix.babasport.pojo.product.ProductQuery;
import com.phoenix.babasport.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by WuDi on 2017-4-25.
 */
@Controller
@RequestMapping("/product")
public class ProductController {
  @Resource
  private ProductService productService;

  @RequestMapping("/list.do")
  public String findProductListPage(Integer pageNo, String name, Long brandId, Integer isShow, Model model) {
    Pagination brandListPage = productService.findBrandListPage(pageNo,name,brandId,isShow);
    model.addAttribute("pagination",brandListPage);
    //页面回显
    model.addAttribute("name",name);
    model.addAttribute("brandId",brandId);
    model.addAttribute("isShow",isShow);
    model.addAttribute("pageNo",pageNo);
    return "product/list";
  }

}
