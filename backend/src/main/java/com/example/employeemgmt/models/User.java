package com.example.employeemgmt.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
//@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(name = "user_username_unique", columnNames = "username"),
        @UniqueConstraint(name = "user_email_unique", columnNames = "email")
})
//@DiscriminatorColumn(name = "employee_type", discriminatorType = DiscriminatorType.STRING,
//        columnDefinition = "VARCHAR(31)")
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "id", updatable = false)
    private Long id;

    //    @NotEmpty
    @Column(name = "username", nullable = false, length = 255)
    private String username;

    //    @NotNull
    @Size(min = 8, message = "Password must have at least 8 characters!")
    @Column(name = "password", nullable = false, length = 255)
    private String password;

    //    @NotBlank
    @Email
    @Column(name = "email", nullable = false, length = 255)
    private String email;

    //    @NotEmpty
    @Column(name = "first_name")
    private String firstName;

    //    @NotEmpty
    @Column(name = "last_name")
    private String lastName;


    @Column(name = "join_Date")
    private Long joinDate;

    //    @NotBlank
    @Column(name = "position")
    private String position;

    //    @NotBlank
    @Column(name = "department")
    private String department;

    //    @NotEmpty
    @Column(name = "salary")
    private String salary;

    @Column(name = "contract_type", length = 255)
    private String contractType;

    @Column
    private boolean isAdmin;

}
