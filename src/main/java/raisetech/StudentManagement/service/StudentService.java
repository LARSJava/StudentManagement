package raisetech.StudentManagement.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raisetech.StudentManagement.controller.converter.StudentConverter;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourse;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.repository.StudentRepository;

@Service
public class StudentService {

  private StudentRepository repository;
  private StudentConverter converter;

  @Autowired
  public StudentService(StudentRepository repository,StudentConverter converter) {
    this.repository = repository;
    this.converter = converter;
  }

  /*
      受講生一覧検索です。
      全件検索を行うので条件指定は行いません。

      @return 受講生一覧(全件)
     */
  public List<StudentDetail> searchStudentList() {
    List<Student> studentList = repository.search();
    List<StudentCourse> studentsCoursesList = repository.searchStudentCourseList();
    return converter.convertStudentDetails(studentList, studentsCoursesList);
  }

  /*
   受講生検索です。
   IDに紐づく任意の受講生の情報を取得したあと、その受講生に紐づく受講生コース情報を取得して設定します。

   @param id 受講生ID
   @return 受講生
  */
  public StudentDetail searchStudent(String id) {
    Student student = repository.searchStudent(id);
    List<StudentCourse> studentCourse = repository.searchStudentsCourses(student.getId());
    return new StudentDetail(student,studentCourse);
  }

  //レジスタートランザクショナル
  @Transactional
  public StudentDetail registerStudent(StudentDetail studentDetail) {
    repository.registerStudent(studentDetail.getStudent());
    for (StudentCourse studentCourse : studentDetail.getStudentsCourses()) {
      studentCourse.setStudentId(studentDetail.getStudent().getId());
      studentCourse.setClassopen(LocalDateTime.now());
      studentCourse.setClasscomp(LocalDateTime.now().plusYears(1));
      repository.registerStudentsCourses(studentCourse);
    }
    return studentDetail;
  }

  //アップデートトランザクショナル
  @Transactional
  public void updateStudent(StudentDetail studentDetail) {
    repository.updateStudent(studentDetail.getStudent());
    for (StudentCourse studentCourse : studentDetail.getStudentsCourses()) {
      repository.updateStudentsCourses(studentCourse);
    }
  }
}
