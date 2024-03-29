package main;

import config.HibernateUtils;
import entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        // Open new session
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {

            // Create transaction
            Transaction transaction = session.beginTransaction();

            // Insert user
//            Date currentDate = new Date();
//            User user = new User();
//            user.setFullname("Hibernate Example");
//            user.setUsername("gpcoder");
//            user.setPassword("123456");
//            user.setCreatedAt(currentDate);
//            user.setModifiedAt(currentDate);
//            Long userId = (Long) session.save(user);
//            System.out.println("User id = " + userId);

            // Get user by id
            // User savedUser = session.get(User.class, 2); => related to the JPA specification
//            User savedUser = session.find(User.class, 2);
//            System.out.println("savedUser: " + savedUser);

            // Update user
//            savedUser.setFullname("GP Coder 22");

            // Commit the current resource transaction, writing any unflushed changes to the database.
            transaction.commit();
        }
    }
}
