package lk.ijse.drivingschoolmanagementsystemorm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @Column(name = "payment_id")
    private String paymentId;

    @Column(nullable = false)
    private Double amount;

    @Column(name = "payment_date", nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String status;

    // M:1 with Student
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
