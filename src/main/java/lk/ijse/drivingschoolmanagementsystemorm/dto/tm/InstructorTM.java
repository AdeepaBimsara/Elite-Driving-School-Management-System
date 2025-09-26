package lk.ijse.drivingschoolmanagementsystemorm.dto.tm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class InstructorTM {
    private String InstructorId;
    private String name;
    private String email;
    private String phone;
    private String specialization;

}
