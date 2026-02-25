package Assessment;
import javax.persistence.*;
import java.time.LocalDate;

public class Operation {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        MedicalRecord record = new MedicalRecord(LocalDate.now(),"Flu","Rest 3 days");

        Patient patient = new Patient("Ali", LocalDate.of(2000, 5, 12),"O+","9999999999");

        patient.setMedicalRecord(record);
        et.begin() ;
        em.persist(patient); 
        et.commit() ;

        System.out.println("Inserted");

        Patient p = em.find(Patient.class, patient.getId());
        System.out.println("Diagnosis: " + p.getMedicalRecord().getDiagnosis());

        
        et.begin();;
        p.getMedicalRecord().setNotes("Updated: Follow-up required");
        et.commit();

        System.out.println("Notes updated.");

        et.begin();
        em.remove(p);
        et.commit();

        System.out.println("Deleted");

        em.close();
        emf.close();
    }
}