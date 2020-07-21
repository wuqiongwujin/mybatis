package wq.mybatis.test.context;

/**
 * @Description
 * @Author Cain
 * @date 2020/7/10
 */
public class ContextHolder {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void setComapnyID(String companyID) {
        threadLocal.set(companyID);
    }

    public static String getCompanyID() {
        return threadLocal.get();
    }
}
