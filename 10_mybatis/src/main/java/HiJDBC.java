import java.sql.*;

public class HiJDBC {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            //加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //通过驱动管理类获取数据库链接
            connection = DriverManager.getConnection("jdbc:mysql://192.168.229.128:3306/hi_mybatis?characterEncoding=utf-8", "root", "Ssmysql_1");
            //定义sql语句 ?表示占位符
            String sql = "select * from t_employees where id = ?";
            //获取预处理statement
            preparedStatement = connection.prepareStatement(sql);
            //设置参数，第一个参数为sql语句中参数的序号（从1开始），第二个参数为设置的参数值
            preparedStatement.setInt(1, 1);
            //向数据库发出sql执行查询，查询出结果集
            resultSet = preparedStatement.executeQuery();
            //遍历查询结果集
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + "  " + resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}