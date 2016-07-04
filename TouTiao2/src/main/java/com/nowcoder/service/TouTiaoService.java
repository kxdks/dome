package com.nowcoder.service;


import com.nowcoder.dao.NewsDao;
import com.nowcoder.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/6/29.
 */
@Service
public class TouTiaoService {
    public String say(){
        return "this is ToutiaoService";
    }

    @Autowired
    private NewsDao newsDao;

    public List<News> getLatestNews(int userId, int offset, int limit){
        return newsDao.selectByUserIdAndOffset(userId, offset, limit);
    }
}
