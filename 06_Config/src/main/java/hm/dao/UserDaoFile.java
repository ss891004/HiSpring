package hm.dao;

/**
 * 此类不能被扫描，不能加@Component
 */
public class UserDaoFile implements  UserDao{
    public UserDaoFile() {
        System.out.println("UserDaoFile-NoneConstructor");
    }

    @Override
    public void addUser() {
        System.out.println("UserDaoFile-addUser");
    }
}
