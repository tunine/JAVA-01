package io.tunine.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class HikariJdbcDemo {

    public static void main(String[] args) throws Exception{
        Connection conn = getConnection();
        Statement sm = conn.createStatement();
        String selectSql = "select *  from student";
        String insertSql = "insert into  student(name) values('tuNine') ";
        String updateSql = "update student set name = 'tunine01' where id = 3";
        String deleteSql = "delete from student where id = 2";
        sm.execute(insertSql);
        //int a = 5/0;
        sm.executeUpdate(updateSql);
        sm.execute(deleteSql);
        ResultSet rs = sm.executeQuery(selectSql);
        while(rs.next()){
            System.out.println("Student{" +
                    "id=" + rs.getString(1) +
                    ", name='" + rs.getString(2) +
                    "'}");
        }
        //conn.getAutoCommit();
        rs.close();
        sm.close();
        conn.close();
    }


    public static Connection getConnection() throws Exception{
        // 如何获得属性文件的输入流？
        // 通常情况下使用类的加载器的方式进行获取：
        InputStream is = HikariJdbcDemo.class.getClassLoader().getResourceAsStream("hikari.properties");
        // 加载属性文件并解析：
        Properties props = new Properties();
        props.load(is);
        HikariConfig config = new HikariConfig(props);
        return new HikariDataSource(config).getConnection();
    }
}
