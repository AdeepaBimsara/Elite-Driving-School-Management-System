package lk.ijse.drivingschoolmanagementsystemorm.dto;

import lombok.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LessonDTO {
    private String lessonId;
    private String status;
    private LocalDate date;
    private String location;
    private int duration;
}
