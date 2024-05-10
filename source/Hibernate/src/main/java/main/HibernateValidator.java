package main;

import config.HibernateUtil;
import entity.User2;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.Set;

public class HibernateValidator {

    public static void main(String[] args) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        User2 user = new User2();
        user.setUsername("AnhVu");
        user.setPassword("1234578");
        user.setCreatedAt(new Date());
        user.setModifiedAt(new Date());

        Set<ConstraintViolation<User2>> constraintViolations = validator.validate(user);

        if (!constraintViolations.isEmpty()) {
            for (ConstraintViolation<User2> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.persist(user);
                transaction.commit();
            }
        }

    }
}
