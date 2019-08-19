package com.xd.pjj.myblog.service;

import com.xd.pjj.myblog.util.Result;

public interface AdminIndexService {
    Result getIndexInfo(String imgPath);
    Result getInfoList();
}
