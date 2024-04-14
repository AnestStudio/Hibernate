package main;

import config.HibernateUtil;
import entity.User;
import entity.UserDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDetailTest {

    public static void main(String[] args) {

        addUserDetail();
    }

    public static void addUserDetail() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            UserDetail userDetail = new UserDetail();
            userDetail.setFirstName("Tuấn");
            userDetail.setLastName("Anh");
            userDetail.setGender("Male");
            userDetail.setBod("11/11/1994");
            userDetail.setMobile("0988777654");
            userDetail.setEmail("anhdt@gmail.com");

            UserDetail userDetail2 = new UserDetail();
            userDetail2.setFirstName("Hoàng");
            userDetail2.setLastName("Minh");
            userDetail2.setGender("Male");
            userDetail2.setBod("25/12/1998");
            userDetail2.setMobile("0988123456");
            userDetail2.setEmail("minhth@gmail.com");

            UserDetail userDetail3 = new UserDetail();
            userDetail3.setFirstName("Hoài");
            userDetail3.setLastName("Hoa");
            userDetail3.setGender("Female");
            userDetail3.setBod("09/09/2002");
            userDetail3.setMobile("0386567223");
            userDetail3.setEmail("hoatth@gmail.com");

            User user = session.get(User.class, 1);
            User user2 = session.get(User.class, 2);
            User user3 = session.get(User.class, 3);

            userDetail.setUser(user);
            userDetail2.setUser(user2);
            userDetail3.setUser(user3);

            session.persist(userDetail);
            session.persist(userDetail2);
            session.persist(userDetail3);

            transaction.commit();
        }
    }
}
