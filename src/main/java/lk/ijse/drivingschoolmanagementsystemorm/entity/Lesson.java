package lk.ijse.drivingschoolmanagementsystemorm.entity;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Lesson {
    private String lessonId;
    private String status;
    private LocalDate date;
    private String location;
    private int duration;
}
