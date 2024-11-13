package web;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.config.AppConfig;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

//        DataSource dataSource = context.getBean(DataSource.class);
//
//        System.out.println(dataSource);
//        System.out.println(dataSource.getConnection());
    }
}
