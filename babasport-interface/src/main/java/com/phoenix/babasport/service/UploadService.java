package com.phoenix.babasport.service;

/**
 * Created by WuDi on 2017-5-4.
 */
public interface UploadService {
  String uploadPicToFDFS(byte[] file_buff,String filename) throws Exception;
}
