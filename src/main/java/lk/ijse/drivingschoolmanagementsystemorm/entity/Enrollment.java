
package lk.ijse.drivingschoolmanagementsystemorm.entity;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Enrollment {
    private String courseId;
    private String studentId;
    private LocalDate enrollmentDate;
    private Double upfrontPaid;

}
