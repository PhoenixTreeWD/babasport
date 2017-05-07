package com.phoenix.babasport.service;

import com.phoenix.babasport.mapper.BrandMapper;
import com.phoenix.babasport.pojo.product.Brand;
import com.phoenix.babasport.pojo.product.BrandQuery;
import com.phoenix.babasport.pojo.page.Pagination;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by WuDi on 2017-4-25.
 */
@Service("brandService")
public class BrandServiceImpl implements BrandService {
  @Resource
  private BrandMapper brandMapper;
  @Override
  public List<Brand> findBrandListNoPage(BrandQuery brandQuery) {
    return brandMapper.findBrandListNoPage(brandQuery);
  }
  public Pagination findBrandListPage(BrandQuery brandQuery) {
    Integer countPage = brandMapper.findCountPage(brandQuery);
    List<Brand> brandListPage = brandMapper.findBrandListPage(brandQuery);
    StringBuilder stringBuilder = new StringBuilder();
    if (brandQuery.getName()!=null){
      stringBuilder.append("name=").append(brandQuery.getName());
    }
    if (brandQuery.getIsDisplay()!=null) {
      stringBuilder.append("&isDisplay=").append(brandQuery.getIsDisplay());
    }
    Pagination pagination = new Pagination(brandQuery.getPageNo(), brandQuery.getPageSize(), countPage,brandListPage);
    String url = "/brand/list.do";
    pagination.pageView(url,stringBuilder.toString());
    return pagination;
  }
  /*
  *  根据id查询Brand（品牌对象）完成编辑修改操作。
  */
  @Override
  public Brand findBrandById(Long brandId) {
    return brandMapper.findBrandById(brandId);
  }

  @Override
  public void updataBrand(BrandQuery brandQuery) {
    brandMapper.updataBrand(brandQuery);
  }

  @Override
  public void deleteBrandList(Long[] ids) {
    brandMapper.deleteBrandList(ids);
  }
}
