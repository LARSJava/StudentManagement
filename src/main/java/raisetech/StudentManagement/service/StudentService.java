package raisetech.StudentManagement.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourse;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.repository.StudentRepository;

@Service
public class StudentService {

  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository){
    this.repository = repository;
  }

  public List<Student> searchStudentList(){
    return repository.searchStudentList();
  }

  public List<StudentCourse> searchStudentCourseList(){
    return repository.searchStudentCourseList();
  }

  @Transactional
  public void registerStudent(StudentDetail studentDetail) {
    repository.registerStudent(studentDetail.getStudent());
    for(StudentCourse studentCourse : studentDetail.getStudentsCourses()){
      studentCourse.setStudentId(studentDetail.getStudent().getId());
      studentCourse.setClassopen(LocalDateTime.now());
      studentCourse.setClasscomp(LocalDateTime.now().plusYears(1));
      repository.registerStudentsCourses(studentCourse);
    }
  }
}
