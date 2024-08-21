package ru.mingrow;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mingrow.model.BirthDate;
import ru.mingrow.model.Company;
import ru.mingrow.model.Role;
import ru.mingrow.model.User;

import java.time.LocalDate;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        Company company = Company.builder()
                .name("Nahodka")
                .build();
        User user = User.of()
                .username("Mingrow")
                .firstname("Nikita")
                .lastname("Vozhegov")
                .birthday(new BirthDate(LocalDate.of(1996, 9, 2)))
                .role(Role.ADMIN)
                .company(company)
                .build();
        try (SessionFactory sf = new Configuration().configure().buildSessionFactory()) {
            var session = sf.openSession();
            session.beginTransaction();
            session.save(company);
            session.save(user);
            session.getTransaction().commit();
        }
    }

}