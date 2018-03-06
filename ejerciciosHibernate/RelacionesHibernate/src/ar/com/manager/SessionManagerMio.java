/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.manager;

import ar.com.modelo.EquipoMio;
import ar.com.modelo.GuerreroMio;
import ar.com.modelo.JugadorMio;
import ar.com.modelo.MagoMio;
import ar.com.modelo.PersonajeMio;
import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author yo
 */
public class SessionManagerMio {

    public SessionManagerMio() {
    }
    
   public static SessionFactory getSession()throws HibernateException{
       Configuration configuration=new Configuration();
       mapearClases(configuration);
       configuration.setProperties(getHibernateProperties());
       StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
       SessionFactory factory=configuration.buildSessionFactory(builder.build());
       return factory;
   }

    private static void mapearClases(Configuration configuration) throws MappingException{
        configuration.addAnnotatedClass(EquipoMio.class);
        configuration.addAnnotatedClass(GuerreroMio.class);
        configuration.addAnnotatedClass(JugadorMio.class);
        configuration.addAnnotatedClass(MagoMio.class);
        configuration.addAnnotatedClass(PersonajeMio.class);
    }

    private static Properties getHibernateProperties() {
        Properties properties=new Properties();
        properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        properties.put("hibernate.connection.url", "jdbc:mysql://localhost/data");
        properties.put("hibernate.connection.username", "root");
        properties.put("hibernate.connection.password", "");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "update");
        return properties;
    }
    
}
