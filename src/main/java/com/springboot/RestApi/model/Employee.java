package com.springboot.RestApi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data                            // @Data(lombok) annotation which helps to reduce boilerplate such as getter & setter, constructor, toString methods.
@Entity                          // @Entity annotation helps to specify that the class is entity.
@Table(name = "Employees")       // @Table annotation help to specify the table name in Database.
// If we don't give the @Table annotation  JPA will automatically fetch the table name as class name.
public class Employee {

    @Id         // @Id annotation specify the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY)           // @GenteratedValue annotation is generally used in conjunction with @Id annotation to automatically generate unique value for primary key columns in our database table.
    private long empID;

    // @Column annotation specify the columns in database table.
    @Column(name = "First Name", nullable = false)  // nullable=false means notnull.
    private String empFirstName;

    @Column(name = "Last Name", nullable = false)
    private String empLastName;

    @Column(name = "Email ID", nullable = false)
    private String empEmail;
}
