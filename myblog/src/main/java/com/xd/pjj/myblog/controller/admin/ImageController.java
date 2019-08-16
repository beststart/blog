package com.xd.pjj.myblog.controller.admin;

import com.xd.pjj.myblog.service.ImageService;
import com.xd.pjj.myblog.util.ImageUtil;
import com.xd.pjj.myblog.util.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/admin/image")
@Controller
@ResponseBody
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping("/getImgList")
    public List<Result> getImgList(HttpServletRequest request){
        String path=request.getServletContext().getRealPath("/upload");
        return imageService.getImgList(path);
    }

    @RequestMapping("/deleteImg")
    public Result deleteImg(HttpServletRequest request,String imgName){
        String path=request.getServletContext().getRealPath("/upload");
        String imgPath=path+"/"+imgName;
        return imageService.deleteImg(imgPath);
    }

    @RequestMapping("/upload")
    public Result upload(HttpServletRequest request, @RequestParam("file")MultipartFile[] files){
        String path=request.getServletContext().getRealPath("/upload")+"/";
        String fileName= ImageUtil.uploadImg(path,files);
        if(StringUtils.isNotEmpty(fileName)){
            return new Result(1,fileName);
        }
        return new Result(0);
    }
}
