package com.xd.pjj.myblog.service;

import com.xd.pjj.myblog.util.Result;

import java.util.List;

public interface ImageService {
    List<Result> getImgList(String path);
    Result deleteImg(String path);
}
