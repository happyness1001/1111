package com.ppq.service;

import com.ppq.dao.CommentMapper;
import com.ppq.pojo.Comment;
import com.ppq.pojo.ResultMap;

import java.util.List;

public class CommentServiceImpl implements CommentService{

    private CommentMapper commentMapper;

    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    //查询所有的评论
    @Override
    public List<Comment> queryAllComment() {
        return commentMapper.queryAllComment();
    }

    @Override
    public List<Comment> queryCommentByIdAndDate(String id, String beginDate, String endDate) {
//        if(id==null || id.equals("")){
//            return queryAllComment();
//        }
        return commentMapper.queryCommentByIdAndDate(id,beginDate,endDate);
    }

    @Override
    public List<String> queryAllPositiveContent() {
        return commentMapper.queryAllPositiveContent();
    }

    @Override
    public List<String> queryAllNegativeContent() {
        return commentMapper.queryAllNegativeContent();
    }

    @Override
    public List<ResultMap> countCommentByIdAndDate(String id, String beginDate, String endDate) {
        return commentMapper.countCommentByIdAndDate(id,beginDate,endDate);
    }

    @Override
    public List<String> queryCommentByIdAndDateAndWeek(String id, String beginDate, String endDate, String weeks) {
        return commentMapper.queryCommentByIdAndDateAndWeek(id,beginDate,endDate,weeks);
    }

}
