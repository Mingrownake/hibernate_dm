package ru.mingrow.model;

import lombok.*;
import ru.mingrow.converter.BirthDateConverter;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "of")
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String firstname;
    private String lastname;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "birth_date")
    @Convert(converter = BirthDateConverter.class)
    private BirthDate birthday;
}
