package wq.mybatis.test.bean;

import java.io.Serializable;

/**
 * @Description
 * @date 2020/2/1
 */
public class DBRoute implements Serializable {

    private static final long serialVersionUID = 7224466009736299713L;
    private long id;
    private String companyID;
    private int type;
    private int dbInstance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDbInstance() {
        return dbInstance;
    }

    public void setDbInstance(int dbInstance) {
        this.dbInstance = dbInstance;
    }
}
