package lk.ijse.drivingschoolmanagementsystemorm.entity;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    private String studentId;
    private String name;
    private String address;
    private String phone;
    private String email;
    private LocalDate registrarDate;

}
