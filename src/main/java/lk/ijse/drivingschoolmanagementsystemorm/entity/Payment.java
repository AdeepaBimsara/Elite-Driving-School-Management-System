package lk.ijse.drivingschoolmanagementsystemorm.entity;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Payment {
    private String paymentId;
    private Double amount;
    private LocalDate date;
    private String status;
}
