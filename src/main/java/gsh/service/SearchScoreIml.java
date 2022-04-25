package gsh.service;

import gsh.dao.SearchScoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SearchScoreIml implements SearchScoreService{

    @Autowired
    @Qualifier("searchScoreDao")
    private SearchScoreDao searchScoreDao;

    @Override
    public float search_score(int userId, int productId) {
       return searchScoreDao.search_score(userId,productId);
    }

}
