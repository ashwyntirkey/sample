package statestreet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StateStreetService implements CommandLineRunner {

	 private static final Logger logger = LoggerFactory.getLogger(StateStreetService.class);
	 
	 
	 @Autowired
	 private StudentDAO studentRepository;
	 
	 @Autowired
	 private CourseDAO courseRepository;
	 
	 
	 public static void main(String[] args) {
	        SpringApplication.run(StateStreetService.class, args);
	    }

	@Override
	@Transactional
	public void run(String... arg0) throws Exception {
		// add courses to students	
		Course physics = new Course("physics");
		Course chemistry = new Course("chemistry");
		Course mathematics = new Course("mathematics");
		Course biology = new Course("biology");
		
		studentRepository.save(new HashSet<Student>(){{
            add(new Student("Carl", new HashSet<Course>(){{
                add(physics);
                add(chemistry);
            }}));

            add(new Student("Adam", new HashSet<Course>(){{
                add(physics);
                add(chemistry);
            }}));
            add(new Student("Bruce", new HashSet<Course>(){{
                add(physics);
                add(chemistry);
            }}));

            
            add(new Student("Dick", new HashSet<Course>(){{
                add(mathematics);
                add(biology);
            }}));
        }});
		
		
		for(Student student : studentRepository.findAll()){
			logger.info("The students are"+student.toString());
		}
		
		// find students in physics course
		
		List<Student> students = courseRepository.findStudentByCourseName("physics");
		{
			
			for(Student student:students){
				logger.info("The students in order are"+student.toString());
			}
		}
		
		// delete a student
		studentRepository.delete(1);
		
		for(Student student : studentRepository.findAll()){
			logger.info("The students are"+student.toString());
		}
		
		

	}

}
