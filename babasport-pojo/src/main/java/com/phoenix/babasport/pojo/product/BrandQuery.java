package com.phoenix.babasport.pojo.product;

import com.phoenix.babasport.utils.fastdfs.FastDFSUtils;

import java.io.Serializable;

/**
 * Created by WuDi on 2017-4-25.
 */
public class BrandQuery implements Serializable {

  private Long id;      // 品牌ID  bigint
  private String name;    // 品牌名称
  private String description; // 描述
  private String imgUrl;    // 图片URL
  private Integer sort;    // 排序  越大越靠前
  private Integer isDisplay;  // 是否可用   0 不可用 1 可用

  private Integer startRow = 0;
  private Integer pageNo = 1;
  private Integer pageSize = 5;

  public Integer getStartRow() {
    return startRow;
  }

  public void setStartRow(Integer startRow) {
    this.startRow = startRow;
  }

  public Integer getPageNo() {
    return pageNo;
  }

  public void setPageNo(Integer pageNo) {
    this.startRow = (pageNo-1)*pageSize;
    this.pageNo = pageNo;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.startRow = (pageNo-1)*pageSize;
    this.pageSize = pageSize;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public Integer getSort() {
    return sort;
  }

  public void setSort(Integer sort) {
    this.sort = sort;
  }

  public Integer getIsDisplay() {
    return isDisplay;
  }

  public void setIsDisplay(Integer isDisplay) {
    this.isDisplay = isDisplay;
  }

}

