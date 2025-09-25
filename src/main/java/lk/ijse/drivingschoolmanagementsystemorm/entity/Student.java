package lk.ijse.drivingschoolmanagementsystemorm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "student_id")
    private String studentId;

    @Column(name = "student_name", nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone", length = 15) // varchar(15)
    private String phone;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "registrar_date")
    private LocalDate registrarDate;

    // 1:1 with User
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    // 1:M with Payment
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Payment> payments;

    // 1:M with Enrollment
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Enrollment> enrollments;


}
