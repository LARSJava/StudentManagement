package raisetech.StudentManagement;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentManagementApplication {

	@Autowired
	private StudentRepository repository;

	private String name = "LARS";
	private int age = 31;
	private String hobby = "音楽鑑賞";

	private Map<String,String> student;

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

	@GetMapping("/student")
	public String getStudent(){
		Student student = repository.searchByName("TanakaTarou");
		return name + " " + age + "歳　" + hobby + "が趣味";
	}

	@PostMapping("/student")
	public void registerStudent(String name,int age){
		repository.registerStudent(name, age);
	}

	@PostMapping("/studentName")
	public void updateStudentName(String name){
		this.name = name;
	}

	//GET POST
	//GETは取得する、リクエストの結果を受け取る。
	//POSTは情報を与える、渡す。
}
