package Assessment;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patients_record")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate dob;

    private String bloodGroup;

    private String phone;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "med_record_id")
    private MedicalRecord medicalRecord;

    public Patient() {}

    public Patient(String name, LocalDate dob, String bloodGroup, String phone) {
        this.name = name;
        this.dob = dob;
        this.bloodGroup = bloodGroup;
        this.phone = phone;
    }

    // Getters & Setters
    public Long getId() {
    	 	return id; 
    }

    public MedicalRecord getMedicalRecord() { 
    		return medicalRecord; 
    	}
    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public String getName() { 
    		return name; 
    	}
    @ManyToMany(mappedBy = "patients")
    private List<Doctor> doctors = new ArrayList<>();

    public List<Doctor> getDoctors() { 
    		return doctors; 
    	}
}