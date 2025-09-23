package lk.ijse.drivingschoolmanagementsystemorm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    @Column(name = "lesson_id")
    private String lessonId;

    @Column(nullable = false)
    private String status;

    @Column(name = "lesson_date", nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String location;

    @Column(name = "lesson_duration", nullable = false)
    private int duration;

    // M:1 with Course
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    // M:1 with Instructor
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
}
