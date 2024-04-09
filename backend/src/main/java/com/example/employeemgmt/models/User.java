package com.example.employeemgmt.models;

import com.example.employeemgmt.models.enums.SalaryCurrency;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
//@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@Table (name = "users", uniqueConstraints = {
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

//    @Column(name = "telegram")
//    private String telegram;

    //    @NotBlank
//    @Column(name = "mobile_phone")
//    private String mobilePhone;

//    @Column(name = "home_phone")
//    private String homePhone;

    //    @NotEmpty
    @Column(name = "address")
    private String address;

    //    @NotEmpty
    @Column(name = "first_name")
    private String firstName;

    //    @NotEmpty
    @Column(name = "last_name")
    private String lastName;


    @Column(name = "join_Date")
    private Long joinDate;


    //    @NotNull
    @JsonFormat(pattern = "yyyy/MM/dd")
    @Column(name = "date_of_entry")
//    @Temporal(TemporalType.DATE)
    private Date dateOfEntry;

    //    @NotBlank
    @Column(name = "position")
    private String position;

    //    @NotBlank
    @Column(name = "department")
    private String department;

    //    @NotEmpty
//    @Column(name = "user_rank")
//    private String userRank;

    //    @NotEmpty
//    @Column(name = "nationality")
//    private String nationality;

    //    @NotEmpty
//    @Column(name = "immediate_supervisor")
//    private String immediateSupervisor;

    //    @NotEmpty
    @Column(name = "salary")
    private String salary;

    //    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "currency")
    private SalaryCurrency salaryCurrency;

    @Column (name = "contract_type", length = 255)
    private String contractType;

    @Column
    private boolean isAdmin;

}
