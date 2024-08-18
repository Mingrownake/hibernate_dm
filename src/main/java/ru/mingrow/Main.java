package ru.mingrow;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        try (SessionFactory sf = new Configuration().configure().buildSessionFactory()) {
            System.out.println("OK");
        }
    }
}