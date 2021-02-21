package io.tunine.jdbc;

import java.sql.*;

public class JdbcDemo {


    public static void main(String[] args)  throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jktime","root","123456");
        //conn.setAutoCommit(false);
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

        System.out.println("---------------------");
        //PrepareStatement 方式
        PreparedStatement prePs=conn.prepareStatement("select * from student where id=?");
        int sid=1;
        prePs.setInt(1, sid);
        rs = prePs.executeQuery();

        while(rs.next()){
            System.out.println("Student{" +
                    "id=" + rs.getString(1) +
                    ", name='" + rs.getString(2) +
                    "'}");
        }

        prePs.close();
        System.out.println("-----------------");

        //批处理方式
        PreparedStatement ps1=conn.prepareStatement("insert into student(name) values(?)");
        ps1.setString(1,"tunine11");
        ps1.addBatch();
        ps1.setString(1,"tunine22");
        ps1.addBatch();
        ps1.executeBatch();
        ps1.close();

        //conn.getAutoCommit();
        conn.close();

    }
}
