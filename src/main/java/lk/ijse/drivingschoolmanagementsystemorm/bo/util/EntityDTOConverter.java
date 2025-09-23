package lk.ijse.drivingschoolmanagementsystemorm.bo.util;

import lk.ijse.drivingschoolmanagementsystemorm.dto.StudentDTO;
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
        student.setEmail(studentDTO.getPhone());
        student.setRegistrarDate(studentDTO.getRegistrarDate());

        return student;

    }
}
