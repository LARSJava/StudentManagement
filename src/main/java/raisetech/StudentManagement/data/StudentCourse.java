package raisetech.StudentManagement.data;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "受講生コース情報")
@Getter
@Setter

public class StudentCourse {
  private String id;
  private String studentId;
  private String course;
  private LocalDateTime classopen;
  private LocalDateTime classcomp;
}
