package Assessment;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "doctors_record")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String specialization;
    private String licenseNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    public Doctor() {}

    public Doctor(String name, String specialization, String licenseNo) {
        this.name = name;
        this.specialization = specialization;
        this.licenseNo = licenseNo;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() { 
    		return department; 
    	}

    public String getName() { 
    		return name; 
    	}
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private List<Appointment> appointments = new ArrayList<>();

    public List<Appointment> getAppointments() {
        return appointments;
    }
    
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "patient_doctors",joinColumns = @JoinColumn(name = "doctor_id"))
    )
    private List<Patient> patients = new ArrayList<>();

    public void addPatient(Patient p) {
        patients.add(p);
        p.getDoctors().add(this);
    }

    public void removePatient(Patient p) {
        patients.remove(p);
        p.getDoctors().remove(this);
    }

    public List<Patient> getPatients() { return patients; }
    
}