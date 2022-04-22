package com.ppq.dao;

import com.ppq.pojo.Comment;
import com.ppq.pojo.ResultMap;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    List<Comment> queryAllComment();
    List<Comment> queryCommentByIdAndDate(@Param("id") String id, @Param("beginDate")String beginDate,@Param("endDate") String endDate);
    List<String> queryAllPositiveContent();
    List<String> queryAllNegativeContent();
    List<ResultMap> countCommentByIdAndDate(@Param("id") String id, @Param("beginDate")String beginDate, @Param("endDate") String endDate);
    List<String> queryCommentByIdAndDateAndWeek(@Param("id") String id, @Param("beginDate")String beginDate, @Param("endDate") String endDate,@Param("weeks") String weeks);
}
