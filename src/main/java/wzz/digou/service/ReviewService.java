package wzz.digou.service;

import wzz.digou.pojo.Review;

import java.util.List;

public interface ReviewService {


    void add(Review c);

    void delete(int id);

    void update(Review c);

    Review get(int id);

    List list(int pid);

    List admin_all_list();

    int getCount(int pid);
}
