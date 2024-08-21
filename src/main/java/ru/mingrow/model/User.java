package ru.mingrow.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mingrow.converter.BirthDateConverter;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "of")
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String firstname;
    private String lastname;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "birth_date")
    @Convert(converter = BirthDateConverter.class)
    private BirthDate birthday;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
