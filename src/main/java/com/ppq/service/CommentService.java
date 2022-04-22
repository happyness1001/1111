package com.ppq.service;

import com.ppq.pojo.Comment;
import com.ppq.pojo.ResultMap;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentService {
    List<Comment> queryAllComment();
    List<Comment> queryCommentByIdAndDate(String id, String beginDate, String endDate);
    List<String> queryAllPositiveContent();
    List<String> queryAllNegativeContent();
    List<ResultMap> countCommentByIdAndDate(String id, String beginDate, String endDate);
    List<String> queryCommentByIdAndDateAndWeek(@Param("id") String id, @Param("beginDate")String beginDate, @Param("endDate") String endDate,@Param("weeks") String weeks);
}
