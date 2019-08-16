package com.xd.pjj.myblog.service.impl;

import com.xd.pjj.myblog.service.ImageService;
import com.xd.pjj.myblog.util.FileUtil;
import com.xd.pjj.myblog.util.Result;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ImageServiceImpl implements ImageService {
    @Override
    public List<Result> getImgList(String path) {
        String[] fileList=FileUtil.getFilesList(path);
        List<Result> list=new ArrayList<>();
        for(int i=0;i<fileList.length;i++){
            list.add(new Result(i,fileList[i]));
        }
        return list;
    }

    @Override
    public Result deleteImg(String path) {
        return new Result(FileUtil.deleteFile(path)?1:0);
    }
}
