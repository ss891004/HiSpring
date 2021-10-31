package hm.dao;

/**
 * 此类不能被扫描，不能加@Component
 */
public class UserDaoCache implements UserDao {

    public UserDaoCache() {
        System.out.println("UserDaoCache-NoneConstructor");
    }

    @Override
    public void addUser() {
        System.out.println("UserDaoCache-addUser");
    }
}
