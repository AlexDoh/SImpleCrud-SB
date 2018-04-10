package com.odmytrenko;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "main-generator")
    private Long id;
    @Column(name = "FIRST_NAME")
    private String name;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "AGE")
    private Integer age;
    @Column(name = "SEX")
    private boolean sex;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Address> addresses;
}