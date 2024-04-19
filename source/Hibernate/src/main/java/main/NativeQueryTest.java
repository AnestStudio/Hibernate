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

// SCALAR QUERIES ------------------------------------------------------------------------------------------------------

//            List<Object[]> users = session.createNativeQuery("SELECT * FROM [User]", Object[].class).getResultList();
//            for (Object[] u : users) {
//                System.out.println(Arrays.toString(u));
//            }

//            List<Object[]> users = session.createNativeQuery("SELECT username, password FROM [User]", Object[].class)
//                    .getResultList();
//            for (Object[] u : users) {
//                System.out.println(Arrays.toString(u));
//            }

// CREATE NAMED NATIVE QUERIES -----------------------------------------------------------------------------------------

//            List<Object[]> users = session.createNamedQuery("FindAllUser", Object[].class).getResultList();
//            for (Object[] u : users) {
//                System.out.println(Arrays.toString(u));
//            }

//            List<Object[]> users = session.createNamedQuery("FindAllUsersByUsernameAndPassword", Object[].class).getResultList();
//            for (Object[] u : users) {
//                System.out.println(Arrays.toString(u));
//            }


// PARAMETER BINDING ---------------------------------------------------------------------------------------------------

//            NativeQuery<Object> query = session.createNativeQuery("SELECT * FROM [User] WHERE user_id = ?1", Object.class);
//            Object[] objects = (Object[]) query.setParameter(1, 1).uniqueResult();
//            System.out.println(Arrays.toString(objects));

//            NativeQuery<Object> query = session.createNativeQuery(
//                    "SELECT * FROM [User] WHERE user_id = :userId",
//                    Object.class
//            );
//            Object[] objects = (Object[]) query.setParameter("userId", 1).uniqueResult();
//            System.out.println(Arrays.toString(objects));


// RESULT HANDLING -----------------------------------------------------------------------------------------------------

//            User user = session.createNativeQuery("SELECT * FROM [User] WHERE user_id = ?1", User.class)
//                    .setParameter(1, 1)
//                    .uniqueResult();
//            System.out.println(user);

//            User user = session.createNamedQuery("FindUserById", User.class)
//                    .setParameter("userId", 1)
//                    .uniqueResult();
//            System.out.println(user);

// @SqlResultSetMapping ------------------------------------------------------------------------------------------------

//            List<UserDTO> users = session.createNativeQuery(
//                    "SELECT username, password FROM [User]",
//                    "UserDTOMapping",
//                    UserDTO.class
//            ).getResultList();
//            for (UserDTO u : users) {
//                System.out.println(u);
//            }

//            List<UserDTO> users = session.createNamedQuery("FindUserByUsernameAndPassword", UserDTO.class)
//                    .getResultList();
//            for (UserDTO u : users) {
//                System.out.println(u);
//            }


//            List<User> users = session.createNamedQuery("FindAllUsersCustom", User.class).getResultList();
//            for (User u : users) {
//                System.out.println(u);
//            }


//            List<Object[]> results = session.createNamedQuery("FindAllUsersWithDetailInfo", Object[].class)
//                    .getResultList();
//            results.forEach(record -> {
//                User u = (User) record[0];
//                UserDetail ud = (UserDetail) record[1];
//                System.out.println(u);
//                System.out.println(ud);
//                System.out.println("-------------");
//            });


//            List<Object[]> results = session.createNamedQuery("FindAllUsersWithFullName", Object[].class)
//                    .getResultList();
//            results.forEach(record -> {
//                User u = (User) record[0];
//                String fullName = (String) record[1];
//                System.out.println(u);
//                System.out.println(fullName);
//                System.out.println("-------------");
//            });

            transaction.commit();
        }
    }
}
