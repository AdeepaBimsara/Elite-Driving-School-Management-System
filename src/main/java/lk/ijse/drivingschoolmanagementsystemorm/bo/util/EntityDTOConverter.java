package lk.ijse.drivingschoolmanagementsystemorm.bo.util;

import lk.ijse.drivingschoolmanagementsystemorm.dto.CourseDTO;
import lk.ijse.drivingschoolmanagementsystemorm.dto.StudentDTO;
import lk.ijse.drivingschoolmanagementsystemorm.entity.Course;
import lk.ijse.drivingschoolmanagementsystemorm.entity.Student;

public class EntityDTOConverter {

    public StudentDTO getStudentDTO(Student student){

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setStudentId(student.getStudentId());
        studentDTO.setName(student.getName());
        studentDTO.setAddress(student.getAddress());
        studentDTO.setPhone(student.getPhone());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setRegistrarDate(student.getRegistrarDate());

        return studentDTO;
    }

    public Student getStudent(StudentDTO studentDTO){

        Student student = new Student();

        student.setStudentId(studentDTO.getStudentId());
        student.setName(studentDTO.getName());
        student.setAddress(studentDTO.getAddress());
        student.setPhone(studentDTO.getPhone());
        student.setEmail(studentDTO.getEmail());
        student.setRegistrarDate(studentDTO.getRegistrarDate());

        return student;

    }

    public CourseDTO getCourseDTO(Course course){

        CourseDTO courseDTO = new CourseDTO();

        courseDTO.setCourseId(course.getCourseId());
        courseDTO.setName(course.getName());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setFee(course.getFee());
        courseDTO.setDuration(course.getDuration());

        return  courseDTO;

    }

    public Course getCourse(CourseDTO courseDTO){

        Course course = new Course();

        course.setCourseId(courseDTO.getCourseId());
        course.setName(courseDTO.getName());
        course.setDescription(courseDTO.getDescription());
        course.setFee(courseDTO.getFee());
        course.setDuration(courseDTO.getDuration());

        return course;

    }
}
