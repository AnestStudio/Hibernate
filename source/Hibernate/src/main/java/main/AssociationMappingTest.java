package main;

import config.HibernateUtil;
import entity.User;
import entity.UserDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AssociationMappingTest {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

//            UserDetail ud = session.get(UserDetail.class, 1);
//            System.out.println(
//                    ud.getUserDetailId() + " - " +
//                    ud.getFirstName() + " " + ud.getLastName()
//            );
//            System.out.println(
//                    ud.getUser().getUserId() + " - " +
//                    ud.getUser().getUsername()
//            );

            User u = session.get(User.class, 1);
            System.out.println(u.getUserId() + " - " + u.getUsername());
            System.out.println(
                    u.getUserDetail().getUserDetailId() + " - " +
                    u.getUserDetail().getFirstName() + " " + u.getUserDetail().getLastName()
            );

            transaction.commit();
        }
    }
}
