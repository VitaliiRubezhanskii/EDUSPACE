package com.vrubizha.eduspace.aws.rds;

import com.vrubizha.eduspace.domain.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AmazonRdsMySqlPractice {


    private static final String DNS_name="";
    private static final String port="";
    private static final String dbName="";
    private static final String username="";
    private static final String password="";


public static Connection connectToAwsRdsMysql(){

    try{
        Class.forName("com.mysql.jdbc.Driver");
    }catch (ClassNotFoundException e){
        e.printStackTrace();

    }

    System.out.println("MySQL JDBC Driver Registered!");
    Connection connection=null;
    try{
        System.out.println("Obtaining connection.....");
        connection=DriverManager.getConnection("jdbc:mysql://"+DNS_name+":"+port+"/"+dbName,username,password);
        System.out.println("Connection established!!!");
    }catch (SQLException ex){
        ex.printStackTrace();
    }
    if (connection!=null){
        System.out.println("SUCCESS!!!! You made it, take control     your database now!");
    }else {
        System.out.println("FAILURE! Failed to make connection!");
    }
    return  connection;
}

    public List<Teacher> getAllTeachers(Connection connection){
                List<Teacher> teachers=new ArrayList<>();
            try {
                    String query="select * from teacher";
                    Statement statement = connection.createStatement();

                     ResultSet resultSet=statement.executeQuery(query);
                           while (resultSet.next()){
                               Teacher teacher=new Teacher();
                            teacher.setPersonId(resultSet.getInt("teacher_id"));
                            teacher.setEmail(resultSet.getString("email"));
                            teacher.setFirstName(resultSet.getString("first_name"));
                            teacher.setLastName(resultSet.getString("last_name"));
                            teacher.setNameByFather(resultSet.getString("name_by_father"));
                            teacher.setProfessionalInterest(resultSet.getString("professional_interest"));
                            teacher.setStartOfCareer(resultSet.getDate("start_of_career"));
                            teachers.add(teacher);
                           }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
                  return teachers;
               }


    public static void main(String[] args) {
        AmazonRdsMySqlPractice amazonRdsMySqlPractice=new AmazonRdsMySqlPractice();
        Connection connection=connectToAwsRdsMysql();
        List<Teacher> teachers=amazonRdsMySqlPractice.getAllTeachers(connection);
        teachers.forEach(teacher -> {
            System.out.println(teacher.toString());});

    }


}
