package main;

import config.HibernateUtil;
import dto.UserDTO;
import entity.User;
import entity.UserDetail;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;

import java.util.Arrays;
import java.util.List;

public class NativeQueryTest {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

//            NativeQuery<User> query = session.createNativeQuery("SELECT * FROM [User]", User.class);
//            List<User> users = query.list();
//            List<User> users = query.getResultList();
//            users.forEach(System.out::println);

//            NativeQuery<User> query = session.createNativeQuery("SELECT * FROM [User] WHERE user_id = ?", User.class);
//            query.setParameter(1, 1);
//            User user = query.getSingleResultOrNull();
//            User user = query.getSingleResult();
//            User user = query.uniqueResult();
//            System.out.println(user);

//            User user = session.createNativeQuery("SELECT * FROM [User] WHERE user_id = ?", User.class)
//                    .setParameter(1, 1)
//                    .uniqueResult();
//            System.out.println(user);

//            User user = session.createNamedQuery("FindUserById", User.class)
//                    .setParameter(1, 1)
//                    .uniqueResult();
//            System.out.println(user);

//            NativeQuery<Object> query = session.createNativeQuery(
//                    "SELECT * FROM [User] WHERE user_id = :id",
//                    Object.class
//            );
//            Object[] objects = (Object[]) query.setParameter("id", 1).uniqueResult();
//            System.out.println(Arrays.toString(objects));

//            NativeQuery<Object> query = session.createNativeQuery("SELECT * FROM [User] WHERE user_id = :id", Object.class);
//            Object[] objects = (Object[]) query.setParameter("id", 1).uniqueResult();
//            System.out.println(Arrays.toString(objects));

//            List<Object[]> users = session.createNativeQuery("SELECT username, password FROM [User]", Object[].class)
//                    .getResultList();
//            for (Object[] u : users) {
//                System.out.println(Arrays.toString(u));
//            }

//            List<Object[]> users = session.createNativeQuery("SELECT username, password FROM [User]", Object[].class)
//                    .getResultList();
//            for (Object[] u : users) {
//                System.out.println(Arrays.toString(u));
//            }

//            List<UserDTO> users = session.createNativeQuery(
//                    "SELECT username, password FROM [User]",
//                    "UsernameAndPasswordDTO",
//                    UserDTO.class
//            ).getResultList();
//            for (UserDTO u : users) {
//                System.out.println(u);
//            }

//            List<Object[]> authors = session.createNamedQuery("FindUsers", Object[].class).getResultList();
//            for (Object[] a : authors) {
//                System.out.println(Arrays.toString(a));
//            }

//            List<UserDTO> users = session.createNamedQuery("FindUserByUsernameAndPassword", UserDTO.class)
//                    .getResultList();
//            for (UserDTO u : users) {
//                System.out.println(u);
//            }

//            List<User> users = session.createNativeQuery(
//                    "SELECT u.user_id as id, u.username as account, u.password, u.created_at, u.modified_at FROM [user] u",
//                    "UserCustomMapping",
//                    User.class
//                    ).getResultList();
//            for (User u : users) {
//                System.out.println(u);
//            }

//            List<User> users = session.createNamedQuery("SelectUsersCustomMapping", User.class)
//                    .getResultList();
//            for (User u : users) {
//                System.out.println(u);
//            }

            List<Object[]> results = session.createNamedQuery("FindUserWithDetailInfoById", Object[].class)
                    .getResultList();
            results.forEach(record -> {
                User u = (User) record[0];
                UserDetail ud = (UserDetail) record[1];
                System.out.println(u);
                System.out.println(ud);
                System.out.println("===========");
            });

            transaction.commit();
        }
    }
}
