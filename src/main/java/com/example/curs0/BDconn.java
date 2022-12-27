package com.example.curs0;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
    public static ResultSet search_namebook(String namebooks) throws Exception{
        Statement statement = connection.createStatement();
        String SQL_SELECT = String.format("select name_books, title_topics, author,quantity_books\n" +
                "from \"public\".books\n" +
                "inner join \"public\".topics on id_topics = \"public\".topics.\"id\" \n" +
                "where name_books = '%s'", namebooks);
        return statement.executeQuery(SQL_SELECT);
    }
    public static ResultSet search_author(String author) throws Exception{
        Statement statement = connection.createStatement();
        String SQL_SELECT = String.format("select name_books, title_topics, author,quantity_books\n" +
                "from \"public\".books\n" +
                "inner join \"public\".topics on id_topics = \"public\".topics.\"id\" \n" +
                "where author = '%s'", author);
        return statement.executeQuery(SQL_SELECT);
    }
    public static ResultSet search_namebookAndAuthor(String namebooks,String author) throws Exception{
        Statement statement = connection.createStatement();
        String SQL_SELECT = String.format("select name_books, title_topics, author,quantity_books\n" +
                "from \"public\".books\n" +
                "inner join \"public\".topics on id_topics = \"public\".topics.\"id\" \n" +
                "where author = '%s' and name_books = '%s'", author, namebooks);
       return statement.executeQuery(SQL_SELECT);
    }

    public static ResultSet search_season_ticket (String nameuser) throws Exception{
        Statement statement = connection.createStatement();
        String SQL_SELECT = String.format("select name_books,name_readers,date_of_issue, date_return\n" +
                "from \"public\".season_ticket\n" +
                "inner join \"public\".readers on id_readers = \"public\".readers.\"id\"\n" +
                "inner join \"public\".books on id_books = \"public\".books.\"id\"\n" +
                "where name_readers = '%s'", nameuser);
        return statement.executeQuery(SQL_SELECT);
    }
    public static void insert_season_ticket (String namebooks, String nameuser) throws Exception{
        int number_colum = 0;
        Statement statement = connection.createStatement();
        String SQL_SELECT_COUNT = String.format("select COUNT(*) from \"public\".books\n" +
                "where name_books = '%s' and quantity_books > 0", namebooks);
        String SQL_Insert = String.format("insert into public.season_ticket (id_libraries, id_books,id_readers , date_of_issue) values\n" +
                "(10842021,public.id_books('%s'),public.id_readers('%s'),now())", namebooks,nameuser);
        String SQL_Update = String.format("update public.books\n" +
                "set quantity_books = quantity_books - 1\n" +
                "where id = public.id_books('%s')", namebooks);
        ResultSet number = statement.executeQuery(SQL_SELECT_COUNT);
        if (number.next()){
        number_colum = number.getInt(1);
        }
        if (number_colum >= 1){
            statement.executeUpdate(SQL_Insert);
            statement.executeUpdate(SQL_Update);
        } else {
            System.out.println("количество книг меньше нуля");
        }
    }
}