package Assessment;
import javax.persistence.*;
import java.util.*;

public class DepartmentDoctor {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("hospitalPU");
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction() ;

        Department cardio = new Department("Cardiology", "Block A", "Dr. Rao");
        Department neuro = new Department("Neurology", "Block B", "Dr. Sharma");

        Doctor d1 = new Doctor("Dr. Mehta", "Cardiologist", "LIC101");
        Doctor d2 = new Doctor("Dr. Smith", "Cardiologist", "LIC102");
        Doctor d3 = new Doctor("Dr. Singh", "Neurologist", "LIC201");
        Doctor d4 = new Doctor("Dr. Roy", "Neurologist", "LIC202");

        cardio.addDoctor(d1);
        cardio.addDoctor(d2);

        neuro.addDoctor(d3);
        neuro.addDoctor(d4);
        
        et.begin();
        em.persist(cardio);
        em.persist(neuro);
        et.commit();

        System.out.println("4 Doctors saved across 2 Departments.");


        Department dep = em.find(Department.class, cardio.getId());
        dep.getDoctors().forEach(doc ->
                System.out.println("Doctor in Cardiology: " + doc.getName())
        );

        Doctor doctor = em.find(Doctor.class, d3.getId());
        System.out.println("Doctor belongs to: " +
                doctor.getDepartment().getName());

      
        et.begin();
        cardio.removeDoctor(d2);
        neuro.addDoctor(d2);
        et.commit();

        System.out.println("Doctor transferred successfully.");

        
        Query query = em.createQuery("SELECT d FROM Doctor d WHERE d.department.name = :dname",Doctor.class);

        query.setParameter("dname", "Cardiology");

        query.getResultList()
                .forEach(d -> System.out.println("Cardio Doctor: " + d.getName()));

        em.close();
        emf.close();
    }
}