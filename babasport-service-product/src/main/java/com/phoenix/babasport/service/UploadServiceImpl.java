package com.phoenix.babasport.service;

import com.phoenix.babasport.utils.fastdfs.FastDFSUtils;
import org.springframework.stereotype.Service;

/**
 * Created by WuDi on 2017-5-4.
 */
@Service("uploadService")
public class UploadServiceImpl implements UploadService {
  @Override
  public String uploadPicToFDFS(byte[] file_buff, String filename) throws Exception {
    return FastDFSUtils.uploadPicToFDFS(file_buff, filename);
  }
}
