package com.phoenix.babasport.service;

import com.phoenix.babasport.pojo.page.Pagination;
import com.phoenix.babasport.pojo.product.ProductQuery;

/**
 * Created by WuDi on 2017-5-5.
 */
public interface ProductService {
  Pagination findBrandListPage(Integer pageNo, String name, Long brandId, Integer isShow);
}
