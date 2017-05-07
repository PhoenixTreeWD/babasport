package com.phoenix.babasport.controller.upload;

import com.phoenix.babasport.service.UploadService;
import com.phoenix.babasport.utils.fastdfs.FastDFSUtils;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by WuDi on 2017-4-26.
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
  @Resource
  private UploadService uploadService;
  @RequestMapping("/uploadPic.do")
  public String uploadPic(MultipartFile multipartFile, HttpServletRequest request, HttpServletResponse response)
    throws IOException {
      //获取文件名
      String filename = multipartFile.getOriginalFilename();
      //获取文件名的拓展名
      String suffix = FilenameUtils.getExtension(filename);
      //生成uuid
      String newFileName = UUID.randomUUID().toString().replace("-", "");
      String url = "/upload/" + newFileName + "." + suffix;
      String realPath = request.getServletContext().getRealPath("");
      multipartFile.transferTo(new File(realPath + url));
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("imgUrl", url); // 回显
      response.setContentType("application/json;charset=UTF-8");
      response.getWriter().write(jsonObject.toString());
      return null;
  }
  @RequestMapping("/uploadPicToFDFS.do")
  public void uploadPicToFDFS(MultipartFile multipartFile, HttpServletResponse response)
    throws Exception {
    //判断上传图片是否为空
    if (multipartFile!=null&&multipartFile.getSize()>0){
    //把图片上传到fastDFS服务器
      String url = uploadService.uploadPicToFDFS(multipartFile.getBytes(), multipartFile.getOriginalFilename());
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("imgUrl", url); // 保存数据库
      jsonObject.put("allUrl", FastDFSUtils.getIMG_URL()+url); // 回显
      response.setContentType("application/json;charset=UTF-8");
      response.getWriter().write(jsonObject.toString());
    }
  }
}
