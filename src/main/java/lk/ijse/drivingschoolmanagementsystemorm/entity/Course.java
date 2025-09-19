package lk.ijse.drivingschoolmanagementsystemorm.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Course {
    private String courseId;
    private String name;
    private String description;
    private Double fee;
    private int duration;

}
