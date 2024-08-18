package ru.mingrow;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.mingrow.model.User;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try (SessionFactory sf = new Configuration().configure().buildSessionFactory()) {
            var session = sf.openSession();
            session.beginTransaction();
            User user = User.of()
                    .username("Mingrow")
                    .firstname("Nikita")
                    .lastname("Vozhegov")
                    .birthday(LocalDate.of(1996, 9, 2))
                    .age(28)
                    .build();
            session.save(user);
            session.getTransaction().commit();
        }
    }

}