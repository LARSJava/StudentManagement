package raisetech.StudentManagement.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourse;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> searchStudentList();

  @Select("SELECT * FROM students WHERE id = #{id}")
  Student searchStudent(String id);

  @Select("SELECT * FROM students_courses")
  List<StudentCourse> searchStudentCourseList();

  @Select("SELECT * FROM students_courses WHERE student_id = #{studentId}")
  List<StudentCourse> searchStudentsCourses(String studentId);

  @Insert("INSERT INTO students(name, furigana, nickname, email, region, age, gender, remark, is_deleted) "
      + "VALUES (#{name}, #{furigana}, #{nickname}, #{email}, #{region}, #{age}, #{gender}, #{remark}, false)")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudent(Student student);

  @Insert("INSERT INTO students_courses(student_id, course, classopen, classcomp)"
  + "VALUES(#{studentId},#{course},#{classopen},#{classcomp})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudentsCourses(StudentCourse studentCourse);

  @Update("UPDATE students SET(name = #{name}, furigana = #{furigana}, nickname = #{nickname}, email = #{email},"
      + " region = #{region}, age = #{age}, gender = #{gender}, remark = #{remark}, is_deleted = #{isDeleted}) WHERE id = #{id}")
  void updateStudent(Student student);

  @Update("UPDATE students_courses SET(course = #{course}　WHERE id = #{id}")
  void updateStudentsCourses(StudentCourse studentCourse);
}
