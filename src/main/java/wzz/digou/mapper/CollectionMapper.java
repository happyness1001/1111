package wzz.digou.mapper;

import org.apache.ibatis.annotations.Param;
import wzz.digou.pojo.Collection;
import wzz.digou.pojo.CollectionExample;

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