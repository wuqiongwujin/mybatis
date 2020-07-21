package wq.mybatis.test.session;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @Description
 * @Author Cain
 * @date 2020/7/10
 */
public class MySqlSessionFactoryBuilder extends SqlSessionFactoryBuilder {

    @Override
    public SqlSessionFactory build(Configuration config) {
        return new MyDefaultSqlSessionFactory(config);
    }
}
