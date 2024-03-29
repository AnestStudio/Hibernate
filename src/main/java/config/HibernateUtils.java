package config;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

    @Getter
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private HibernateUtils() {
        super();
    }

    private static SessionFactory buildSessionFactory() {
        // Load configuration from hibernate.properties file
        Configuration configuration = new Configuration().configure("hibernate.properties");

        // Apply configuration properties
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());

        // Build the session factory
        return configuration.buildSessionFactory(builder.build());

//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder() //
//                .configure() // Load hibernate.cfg.xml from resource folder by default
//                .build();
//        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
//        return metadata.getSessionFactoryBuilder().build();
    }

    public static void close() {
        getSessionFactory().close();
    }
}
