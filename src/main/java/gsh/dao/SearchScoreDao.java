package gsh.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

public interface SearchScoreDao {
//查询用户对商品的评分
    float search_score (@Param("userId") int userId , @Param("productId") int productId);
}
