package com.phoenix.babasport.utils.fastdfs;

import org.apache.commons.io.FilenameUtils;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by WuDi on 2017-5-4.
 */
public class FastDFSUtils {
  private static final String IMG_URL = "http://192.168.200.128/";
  public static String uploadPicToFDFS(byte[] file_buff, String filename) throws Exception{
    // 1、加载FastDFS的配置文件
    ClassPathResource resource = new ClassPathResource("fdfs_client.conf");
    // 2、初始化FastDFS的配置文件
    ClientGlobal.init(resource.getClassLoader().getResource("fdfs_client.conf").getPath());
    // 3、获取trackerClient
    TrackerClient trackerClient = new TrackerClient();
    // 4、获取trackerServer
    TrackerServer trackerServer = trackerClient.getConnection();
    // 5、通过trackerServer获取存储服务器的client
    StorageClient1 storageClient1 = new StorageClient1(trackerServer, null);
    // 6、通过存储服务器的client实现附件上传，返回附件的路径
    String file_ext_name = FilenameUtils.getExtension(filename);
    // path例如：group1/M00/00/01/wKjIgFWOYc6APpjAAAD-qk29i78248.jpg
    String path = storageClient1.upload_file1(file_buff, file_ext_name, null);
    return path;

  }
  public static String getIMG_URL(){
    return IMG_URL;
  }
}
