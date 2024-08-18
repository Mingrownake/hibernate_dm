package ru.mingrow;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.mingrow.model.BirthDate;
import ru.mingrow.model.Role;
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
                    .birthday(new BirthDate(LocalDate.of(1996, 9, 2)))
                    .role(Role.ADMIN)
                    .build();
            session.save(user);
            session.getTransaction().commit();
        }
    }

}