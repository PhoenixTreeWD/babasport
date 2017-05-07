package com.phoenix.babasport.mapper;

import com.phoenix.babasport.pojo.product.Brand;
import com.phoenix.babasport.pojo.product.BrandQuery;

import java.util.List;

/**
 * Created by WuDi on 2017-4-25.
 */
public interface BrandMapper {

  List<Brand> findBrandListNoPage(BrandQuery brandQuery);

  List<Brand> findBrandListPage(BrandQuery brandQuery);

  Integer findCountPage(BrandQuery brandQuery);

  Brand findBrandById(Long brandId);

  void updataBrand(BrandQuery brandQuery);

  void deleteBrandList(Long[] ids);
}
