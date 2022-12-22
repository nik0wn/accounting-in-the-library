package com.example.curs0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BDconn {
    private static final String BD_USERNAME = "postgres";
    private static final String BD_PASSWORD = "1505";
    private static final String BD_URL = "jdbc:postgresql://localhost:5432/curs3";

    private static Connection connection;

    public static Connection conect () {
        connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(BD_URL,BD_USERNAME,BD_PASSWORD);
            if (connection != null){
                System.out.println("Подлючено");
            }else {
                System.out.println("Неудолось подлючиться");
            }

        } catch (Exception e){
            System.out.println(e);
        }
        return connection;
    }
    public static void input_bd(String name,String address, String phone ) throws Exception{ // добавление данных
        Statement statement = connection.createStatement();
        String SQL_INSERT = String.format("insert into \"public\".readers (name_readers, address, phone) values ('%s', '%s', '%s')", name,address,phone);
        statement.executeUpdate(SQL_INSERT);
    }
    public static void input_books(String topic, String author, String name_books, String publishers, int year_book, int quantity_book ) throws Exception{ // добавление данных
        Statement statement = connection.createStatement();
        String SQL_INSERT = String.format("insert into public.books (id_libraries,id_topics,author,name_books,publishers,year_books,quantity_books) \n" +
                "values (10842021,\"public\".id_title_topic('%s'),'%s', '%s','%s','%d',%d)", topic, author, name_books,publishers, year_book, quantity_book);
        statement.executeUpdate(SQL_INSERT);
            }
}
