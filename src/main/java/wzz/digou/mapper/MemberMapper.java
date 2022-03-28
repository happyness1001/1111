package wzz.digou.mapper;

import wzz.digou.pojo.Alike;
import wzz.digou.pojo.Member;
import wzz.digou.pojo.MemberExample;

import java.util.List;

public interface MemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Member record);

    int insertSelective(Member record);

    List<Member> selectByExample(MemberExample example);

    //模糊查询
    List<Member> selectByExampleAlike(Alike alike);

    Member selectByPrimaryKey(String member_phone);


    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);

    // 自己玩
    Member selectUserByName(String member_phone);


}
