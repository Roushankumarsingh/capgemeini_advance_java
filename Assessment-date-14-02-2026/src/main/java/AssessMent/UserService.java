package AssessMent;

import java.util.*; 
import javax.persistence.*;

public class UserService {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ; 
	EntityManager em = emf.createEntityManager() ; 
	EntityTransaction et = em.getTransaction() ;
	public void registerPatient() {
		PatientDao pd = new PatientDao() ;
		Patient p = new Patient() ; 
		p.setPid(106);
		p.setContact("98765432");
		p.setPname("Rous");
		MedicalRecord md = new MedicalRecord() ;
		md.setAllergies("Al");
		md.setBlood("A-");
		md.setMid(1009); 
		p.setMedical(md);
		pd.savePatient(p, md);
	}
	public void addDoctor() {
		Doctor d = new Doctor() ; 
		Appointment a = new Appointment() ; 
		a.setAid(10011);
		a.setFee(2500.0);
		Patient p = new Patient() ;
		p.setContact("987456321");
		p.setPage(35);
		p.setPid(115);
		p.setPname("Harsha Bandra");
		MedicalRecord md = new MedicalRecord()  ; 
		md.setAllergies("All");
		md.setBlood("A+");
		md.setMid(10015);
		p.setMedical(md);
		a.setVisitDate("16-02-2025");
		a.setPatient(p);
		List<Appointment> list = new ArrayList<>() ; 
		list.add(a) ; 
		d.setAppoint(list);
		d.setDname("Rohit");
		d.setId(2);
		d.setSpeical("Cardiologist");
		DoctorDao dd = new DoctorDao() ; 
		et.begin();   
		em.persist(a);
		em.persist(p);
		em.persist(md);
		et.commit();   
		dd.saveDoctor(d);
	}
	public void appointPatient() {
		Appointment a = new Appointment() ; 
		a.setAid(10007) ; 
		a.setFee(3200.0);
		a.setVisitDate("18-02-2026");
		Patient p = new Patient() ;
		p.setContact("987654321");
		p.setPage(29);
		p.setPid(107);
		p.setPname("Roushan");
		MedicalRecord md = new MedicalRecord() ; 
		md.setAllergies("all");
		md.setBlood("B+");
		md.setMid(1007);
		et.begin();
		em.persist(md);
		em.persist(p);
		et.commit(); 
		a.setPatient(p);
		AppointmentDao ad = new AppointmentDao() ; 
		ad.saveAppoint(a);
	}
	public void updateAppointFee() {
		int id = 10007 ;
		double fee = 52400.0;
		AppointmentDao ad = new AppointmentDao()  ; 
		ad.updateFee(id, fee); 
	}
	public void fetchAppointment() {
		int id = 2 ; 
		AppointmentDao ad = new AppointmentDao() ; 
		ad.findAppointment(id); 
	}
	public void deleteTest() {
		int id = 107 ; 
		PatientDao pd = new PatientDao() ; 
		pd.deletePatient(id) ; 
	}
	public static void main(String[] args) {
		UserService us = new UserService() ; 
//		us.registerPatient();
//		us.addDoctor(); 
//		us.appointPatient();
//		us.updateAppointFee();
//		us.fetchAppointment();
	}
}
