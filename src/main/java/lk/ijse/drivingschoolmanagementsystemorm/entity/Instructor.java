package lk.ijse.drivingschoolmanagementsystemorm.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class InstructorDTO {
    private String InstructorId;
    private String name;
    private String email;
    private String phone;
    private String specialization;

}
