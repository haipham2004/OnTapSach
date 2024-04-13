package com.example.OnTapSach.config;
import com.example.OnTapSach.entity.NhaXuatBan;
import com.example.OnTapSach.entity.Sach;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import java.util.Properties;

public class HibernateConfig {

    private static final SessionFactory FACTORY;

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        System.out.println(getFACTORY());
        System.out.println("Kết nối thành công");
    }

    static {
        Configuration conf = new Configuration();
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
        properties.put("hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put("hibernate.connection.url", "jdbc:sqlserver://localhost:1433;databaseName=PTPM_FINALLY_JAVA_SOF3011");
        properties.put("hibernate.connection.username", "sa");
        properties.put("hibernate.connection.password", "Haitam77");
        properties.put("hibernate.show_sql", "true");
        conf.setProperties(properties);
        conf.addAnnotatedClass(Sach.class);
        conf.addAnnotatedClass(NhaXuatBan.class);
        ServiceRegistry registry = (new StandardServiceRegistryBuilder()).applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);
    }
}
