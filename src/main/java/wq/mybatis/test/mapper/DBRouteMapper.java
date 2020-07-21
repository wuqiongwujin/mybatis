package wq.mybatis.test.mapper;

import org.apache.ibatis.annotations.Param;
import wq.mybatis.test.bean.DBRoute;

import java.util.List;

/**
 * @Description
 * @date 2020/2/1
 */
public interface DBRouteMapper {

    List<DBRoute> listDBRouteByCompanyIDAndType(@Param("companyID")String companyID, @Param("type")int type);

    void add(DBRoute dbRoute);

    int updateByID(@Param("id") long id,@Param("newDBInstance") int newDBInstance);
}
