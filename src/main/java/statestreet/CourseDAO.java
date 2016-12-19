package statestreet;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseDAO extends JpaRepository<Course, Integer>{

	@Query("SELECT c.student FROM Course c where c.name = :name order by c.name") 
	List<Student> findStudentByCourseName(@Param("name") String name);

	

	
}
