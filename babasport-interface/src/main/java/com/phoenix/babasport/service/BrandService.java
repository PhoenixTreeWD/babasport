package com.phoenix.babasport.service;

import com.phoenix.babasport.pojo.product.Brand;
import com.phoenix.babasport.pojo.product.BrandQuery;
import com.phoenix.babasport.pojo.page.Pagination;

import java.util.List;

/**
 * Created by WuDi on 2017-4-25.
 */
public interface BrandService {
  List<Brand> findBrandListNoPage(BrandQuery brandQuery);

  Pagination findBrandListPage(BrandQuery brandQuery);

  Brand findBrandById(Long brandId);

  void updataBrand(BrandQuery brandQuery);

  void deleteBrandList(Long[] ids);
}
