package raisetech.StudentManagement.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourse;

/*
  受講生テーブルと受講生コース情報テーブルと紐づくRepositoryです。
 */
@Mapper
public interface StudentRepository {

  /*
    受講生の全件検索を行います。

    @return 受講生一覧(全件)
   */
  @Select("SELECT * FROM students")
  List<Student> search();

  /*
    受講生の検索を行います。

    @param id 受講生ID
    @return 受講生
   */
  @Select("SELECT * FROM students WHERE id = #{id}")
  Student searchStudent(String id);

  /*
    受講生のコース情報の全件検索を行います。

    @return 受講のコース情報(全件)
   */
  @Select("SELECT * FROM students_courses")
  List<StudentCourse> searchStudentCourseList();

    /*
      受講生IDに紐づく受講生コース情報を検索します。

      @param studentId 受講生ID
      @return 受講生IDに紐づく受講生コース情報
    */
  @Select("SELECT * FROM students_courses WHERE student_id = #{studentId}")
  List<StudentCourse> searchStudentsCourses(String studentId);

  //新規データ
  @Insert("INSERT INTO students(name, furigana, nickname, email, region, age, gender, remark, is_deleted) "
      + "VALUES (#{name}, #{furigana}, #{nickname}, #{email}, #{region}, #{age}, #{gender}, #{remark}, false)")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudent(Student student);

  @Insert("INSERT INTO students_courses(student_id, course, classopen, classcomp)"
  + "VALUES(#{studentId},#{course},#{classopen},#{classcomp})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudentsCourses(StudentCourse studentCourse);

  //アップデート
  @Update("UPDATE students SET name = #{name}, furigana = #{furigana}, nickname = #{nickname}, email = #{email},"
      + " region = #{region}, age = #{age}, gender = #{gender}, remark = #{remark}, is_deleted = #{isDeleted} WHERE id = #{id}")
  void updateStudent(Student student);

  @Update("UPDATE students_courses SET course = #{course} WHERE id = #{id}")
  void updateStudentsCourses(StudentCourse studentCourse);
}
