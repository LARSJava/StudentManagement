package raisetech.StudentManagement;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StudentCourse {
  private String ID;
  private String students_id;
  private String course;
  private LocalDateTime classopen;
  private LocalDateTime classcomp;
}
