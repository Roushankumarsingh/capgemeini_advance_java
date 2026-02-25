package Assessment;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime appointDate;

    private String status;

    private String reason;

    public Appointment() {}

    public Appointment(LocalDateTime appointDate,String status,String reason) {
        this.appointDate = appointDate;
        this.status = status;
        this.reason = reason;
    }

    public String getStatus() { 
    		return status;
    	}
    public void setStatus(String status) { 
    		this.status = status; 
    	}
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

    public Prescription getPrescription() { 
    		return prescription; 
    	}
    public void setPrescription(Prescription prescription) {
      this.prescription = prescription;
    }
}