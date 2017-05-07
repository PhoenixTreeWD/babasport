package com.phoenix.babasport.controller.brand;

import com.phoenix.babasport.pojo.product.Brand;
import com.phoenix.babasport.pojo.product.BrandQuery;
import com.phoenix.babasport.pojo.page.Pagination;
import com.phoenix.babasport.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by WuDi on 2017-4-25.
 */
@Controller
@RequestMapping("/brand")
public class BrandController {
  @Resource
  private BrandService brandService;
  @RequestMapping("/list.do")
  public String brandList(BrandQuery brandQuery, Model model){
    Pagination brandListPage = brandService.findBrandListPage(brandQuery);
    model.addAttribute("pagination",brandListPage);
    model.addAttribute("name",brandQuery.getName());
    model.addAttribute("isDisplay",brandQuery.getIsDisplay());
    model.addAttribute("pageNo",brandQuery.getPageNo());
    /*model.addAttribute("brands",brands);
    model.addAttribute("brandQuery",brandQuery);*/
    return "brand/list";
  }
  @RequestMapping("/edit.do")
  public String brandEdit(Long brandId, Model model) {
    Brand brand = brandService.findBrandById(brandId);
    model.addAttribute("brand", brand);
    return "brand/edit";
  }
  //修改brand
  @RequestMapping("/editBrand.do")
  public String editBrand(BrandQuery brandQuery) {
    brandService.updataBrand(brandQuery);
    return "redirect:list.do";
  }
  //批量删除表单
  @RequestMapping("/delete.do")
  public String deleteBrand(Long[] ids) {
    brandService.deleteBrandList(ids);
    return "forward:list.do";
  }

}
