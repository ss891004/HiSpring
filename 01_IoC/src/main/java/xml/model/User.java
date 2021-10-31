package xml.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.*;

public class User {
    private Integer id;
    private String password;
    private String sex;
    private Integer age;
    private Date bornDate;
    private String[] hobbys;
    private Set<String> phones;
    private List<String> names;
    private List<Address> adds;
    private Map<String, String> countries;
    private Properties files;
    // 自建类型
    private Address address;


    public User() {
        System.out.println("构造User对象");
    }

    public List<Address> getAdds() {
        return adds;
    }


    public void setAdds(List<Address> adds) {
        this.adds = adds;
    }

    @PostConstruct
    //初始化
    public void a() {
        System.out.println("init");
    }

    @PreDestroy
    //销毁
    public void b() {
        System.out.println("destroy");
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        //System.out.println("set address");
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String[] getHobbys() {
        return hobbys;
    }

    public void setHobbys(String[] hobbys) {
        this.hobbys = hobbys;
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public Map<String, String> getCountries() {
        return countries;
    }

    public void setCountries(Map<String, String> countries) {
        this.countries = countries;
    }

    public Properties getFiles() {
        return files;
    }

    public void setFiles(Properties files) {
        this.files = files;
    }
}