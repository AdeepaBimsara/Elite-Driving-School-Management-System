package lk.ijse.drivingschoolmanagementsystemorm.dto.tm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class CourseTM {
    private String courseId;
    private String name;
    private String description;
    private Double fee;
    private int duration;

}
