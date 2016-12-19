package statestreet;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Student {
    private int id;
    private String name;
    private Set<Course> course;

    public Student() {

	}
    
    
    public Student(String name) {

		this.name = name;
	}


	public Student(String name, Set<Course> course) {

		this.name = name;
		this.course = course;
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

	 @ManyToMany(cascade = CascadeType.ALL)
	 @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
	public Set<Course> getCourse() {
		return course;
	}


	public void setCourse(Set<Course> course) {
		this.course = course;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
    
    
    

}
