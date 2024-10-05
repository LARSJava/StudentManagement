package raisetech.StudentManagement.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourse;
import raisetech.StudentManagement.repository.StudentRepository;

@Service
public class StudentService {

  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository){
    this.repository = repository;
  }

//  public List<Student> searchStudentList(){
//    repository.searchStudentList();
//    return repository.searchStudentList();
//  }

  public List<Student> searchStudentList(){
    List<Student> allStudents = repository.searchStudentList();
        return allStudents.stream()
        .filter(student -> student.getAge() >= 30 && student.getAge() < 40)
        .collect(Collectors.toList());
  }

//  public List<StudentCourse> searchStudentCourseList(){
//    return repository.searchStudentCourseList();
//  }

  public List<StudentCourse> searchStudentCourseList() {
    List<StudentCourse> allCourses = repository.searchStudentCourseList();

    return allCourses.stream()
        .filter(course -> "Javaコース".equals(course.getCourse()))
        .collect(Collectors.toList());
  }
}
