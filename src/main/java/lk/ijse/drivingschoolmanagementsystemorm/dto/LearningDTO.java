package lk.ijse.drivingschoolmanagementsystemorm.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LearningDTO {
    private String courseId;
    private String instructorId;
    private String status;

}
