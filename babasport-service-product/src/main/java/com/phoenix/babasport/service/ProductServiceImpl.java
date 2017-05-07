package com.phoenix.babasport.service;

import com.phoenix.babasport.pojo.page.Pagination;
import com.phoenix.babasport.pojo.product.ProductQuery;
import org.springframework.stereotype.Service;

/**
 * Created by WuDi on 2017-5-4.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

  @Override
  public Pagination findBrandListPage(Integer pageNo, String name, Long brandId, Integer isShow) {
    return null;
  }
}
