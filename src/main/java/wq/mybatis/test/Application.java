package wq.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import wq.mybatis.test.bean.DBRoute;
import wq.mybatis.test.context.ContextHolder;
import wq.mybatis.test.mapper.DBRouteMapper;
import wq.mybatis.test.proxy.MyMapperProxy;
import wq.mybatis.test.session.MySqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;
import java.util.UUID;

/**
 * @Description
 * @date 2020/2/1
 */
public class Application {

    public static SqlSessionFactory sessionFactory;
    static {
        try {
            // 使用MyBatis提供的Resources类加载mybatis的配置文件
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            // 构建sqlSession的工厂
            sessionFactory = new MySqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        //addDBRoute();
        listDBRoute();
    }

    public static void listDBRoute() {
        String companyID = "123";
        ContextHolder.setComapnyID(companyID);
        int type = 1;
        // sqlSession里开启了事务transaction,transaction里创建了connection,所有更新sql都是用这个connection
        SqlSession sqlSession = sessionFactory.openSession();
        DBRouteMapper mapper = sqlSession.getMapper(DBRouteMapper.class);
        List<DBRoute> route = mapper.listDBRouteByCompanyIDAndType(companyID, type);
        System.out.println(route.iterator().next().getDbInstance());
        mapper.updateByID(0, 1);
        DBRouteMapper mapper2 = sqlSession.getMapper(DBRouteMapper.class);
        mapper2.updateByID(1584000748790L, 1);
        List<DBRoute> route2 = mapper.listDBRouteByCompanyIDAndType(companyID, type);
        System.out.println(route2.iterator().next().getDbInstance());
        sqlSession.commit();
        sqlSession.close();
    }

    public static void addDBRoute() {
        DBRoute dbRoute = new DBRoute();
        dbRoute.setId(System.currentTimeMillis());
        dbRoute.setCompanyID("123");
        dbRoute.setDbInstance(1);
        dbRoute.setType(2);
        SqlSession sqlSession = sessionFactory.openSession();
        DBRouteMapper mapper = sqlSession.getMapper(DBRouteMapper.class);
        mapper.add(dbRoute);
        sqlSession.commit();
        sqlSession.close();
    }
}
