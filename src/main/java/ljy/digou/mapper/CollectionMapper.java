package ljy.digou.mapper;

import ljy.digou.pojo.Collection;
import ljy.digou.pojo.CollectionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectionMapper {
    long countByExample(CollectionExample example);

    int deleteByExample(CollectionExample example);

    int deleteByPrimaryKey(Integer scid);

    int insert(Collection record);

    int insertSelective(Collection record);

    List<Collection> selectByExample(CollectionExample example);

    Collection selectByPrimaryKey(Integer scid);

    int updateByExampleSelective(@Param("record") Collection record, @Param("example") CollectionExample example);

    int updateByExample(@Param("record") Collection record, @Param("example") CollectionExample example);

    int updateByPrimaryKeySelective(Collection record);

    int updateByPrimaryKey(Collection record);
}