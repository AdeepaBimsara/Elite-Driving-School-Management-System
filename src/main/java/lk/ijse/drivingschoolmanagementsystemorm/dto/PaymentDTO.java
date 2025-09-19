package lk.ijse.drivingschoolmanagementsystemorm.dto;

import lombok.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PaymentDTO {
    private String paymentId;
    private Double amount;
    private LocalDate date;
    private String status;
}
