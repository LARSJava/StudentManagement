package raisetech.StudentManagement;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentManagementApplication {

	private String name = "LARS";
	private String age = "31";
	private String hobby = "音楽鑑賞";

	private Map<String,String> student;

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

	@GetMapping("/studentInfo")
	public String getStudentInfo(){
		return name + " " + age + "歳　" + hobby + "が趣味";
	}

	@PostMapping("/studentInfo")
	public void setStudentInfo(String name,String age){
		this.name = name;
		this.age = age;
		this.hobby = hobby;
	}

	@PostMapping("/studentName")
	public void updateStudentName(String name){
		this.name = name;
	}

	//GET POST
	//GETは取得する、リクエストの結果を受け取る。
	//POSTは情報を与える、渡す。
}
