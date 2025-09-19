
package lk.ijse.drivingschoolmanagementsystemorm.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EnrollmentDTO {
    private String courseId;
    private String studentId;
    private LocalDate enrollmentDate;
    private Double upfrontPaid;

}
