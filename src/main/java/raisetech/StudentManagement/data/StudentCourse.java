package raisetech.StudentManagement.data;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StudentCourse {
  private String id;
  private String studentsId;//変更しました。
  private String course;
  private LocalDateTime classopen;
  private LocalDateTime classcomp;
}
