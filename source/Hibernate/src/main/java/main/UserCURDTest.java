package main;

import config.HibernateUtil;
import entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserCURDTest {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

//            Date currentDate = new Date();
//            User user = new User();
//            user.setUsername("AnhDT");
//            user.setPassword("12345678");
//            user.setCreatedAt(currentDate);
//            user.setModifiedAt(currentDate);
//
//            User user2 = new User();
//            user2.setUsername("MinhTH");
//            user2.setPassword("12345678");
//            user2.setCreatedAt(currentDate);
//            user2.setModifiedAt(currentDate);
//
//            User user3 = new User();
//            user3.setUsername("HoaTTH");
//            user3.setPassword("12345678");
//            user3.setCreatedAt(currentDate);
//            user3.setModifiedAt(currentDate);
//
//            session.persist(user);
//            session.persist(user2);
//            session.persist(user3);
//            Long id = (Long) session.save(user);
//            System.out.println(id);


//            Long id2 = (Long) session.save(user);
//            System.out.println(id2);

            User user = session.find(User.class, 1);
//            System.out.println(user);
//
//            User user2 = session.get(User.class, 2);
//            System.out.println(user2.getUserDetail());


//            User user = new User();
//            user.setUserId(3L);
//            session.update(user);

//            User user = session.find(User.class, 1);
//            user.setPassword("00000000");
//            session.merge(user);


//            // Delete a persistent object
//            User user = session.find(User.class, 1);
//            if (user != null) {
//                session.remove(user);
//            }

//            // Delete a transient object
//            User user = new User();
//            user.setUserId(1L);
//            session.remove(user);


//            NativeQuery<User> query = session.createNativeQuery("SELECT * FROM [User]", User.class);
//            List<User> users = query.list();
//            List<User> users = query.getResultList();
//            users.forEach(System.out::println);


//            NativeQuery<Object> query2 = session.createNativeQuery("SELECT * FROM [User] WHERE user_id = :id", Object.class);
//            Object[] objects = (Object[]) query2.setParameter("id", 4).uniqueResult();
//            System.out.println(Arrays.toString(objects));

            transaction.commit();
        }
    }
}
