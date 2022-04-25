package gsh.service;

public interface  SearchScoreService {

    //查询用户对商品的评分
    float search_score (int userId,int productId);

}
