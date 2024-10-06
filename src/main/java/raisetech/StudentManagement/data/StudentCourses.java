package raisetech.StudentManagement.data;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StudentCourses {
  private String id;
  private String students_id;
  private String course;
  private LocalDateTime classopen;
  private LocalDateTime classcomp;
}
