package statestreet;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course {
    private int id;
    private String name;
    private Set<Student> student;

 
    public Course() {

	}
    
    
	public Course(String name) {

		this.name = name;
	}


	public Course(String name, Set<Student> student) {
		this.name = name;
		this.student = student;
	}


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToMany(fetch=FetchType.EAGER,mappedBy = "course")
	public Set<Student> getStudent() {
		return student;
	}
	public void setStudent(Set<Student> student) {
		this.student = student;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
    
	

}
