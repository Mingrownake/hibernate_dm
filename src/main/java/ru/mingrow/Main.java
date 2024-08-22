package ru.mingrow;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mingrow.model.Company;


public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        try (SessionFactory sf = new Configuration().configure().buildSessionFactory()) {
            var session = sf.openSession();
            session.beginTransaction();
            Company company = session.get(Company.class, 2);
            System.out.println(company.getUsers());
            session.getTransaction().commit();
        }
    }

}