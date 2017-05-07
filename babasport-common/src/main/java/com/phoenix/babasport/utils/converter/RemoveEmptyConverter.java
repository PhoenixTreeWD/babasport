package com.phoenix.babasport.utils.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * Created by WuDi on 2017-4-26.
 */
public class RemoveEmptyConverter implements Converter<String,String>{
  @Override
  public String convert(String source) {
    if (source != null) {
      String trim = source.trim();
      if (!"".equals(trim)) {
        return trim;
      }
    }
    return null;
  }
}
