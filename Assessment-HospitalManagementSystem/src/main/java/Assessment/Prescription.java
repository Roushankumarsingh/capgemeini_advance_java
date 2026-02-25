package Assessment;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "prescriptions")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medicines;
    private String dosage;
    private LocalDate issuedDate;
    private boolean isActive;


    public Prescription(String medicines,String dosage,LocalDate issuedDate,boolean isActive) {
        this.medicines = medicines;
        this.dosage = dosage;
        this.issuedDate = issuedDate;
        this.isActive = isActive;
    }
}
