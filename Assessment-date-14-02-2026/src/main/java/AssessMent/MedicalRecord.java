package AssessMent;
import javax.persistence.*;

@Entity 
public class MedicalRecord {
	@Id
	int mid ; 
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	String blood ; 
	String allergies ;
	
}
