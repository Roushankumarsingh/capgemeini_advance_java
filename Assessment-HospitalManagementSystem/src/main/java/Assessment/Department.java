package Assessment;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "departments_records")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String headDoctorName;

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private List<Doctor> doctors = new ArrayList<>();

    public Department() {}

    public Department(String name, String location, String headDoctorName) {
        this.name = name;
        this.location = location;
        this.headDoctorName = headDoctorName;
    }

    public void addDoctor(Doctor d) {
        doctors.add(d);
        d.setDepartment(this);
    }

    public void removeDoctor(Doctor d) {
        doctors.remove(d);
        d.setDepartment(null);
    }

    public List<Doctor> getDoctors() { 
    		return doctors; 
    	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
}