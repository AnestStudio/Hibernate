package main;

import config.HibernateUtil;
import entity.User;
import entity.User2;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.concurrent.TimeUnit;

public class User2Test {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            User2 user1 = session.get(User2.class, 6);
            System.out.println(user1);
            TimeUnit.MILLISECONDS.sleep(12000);
            session.evict(user1);
            User2 user2 = session.get(User2.class, 6);
            System.out.println(user2);

            transaction.commit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
