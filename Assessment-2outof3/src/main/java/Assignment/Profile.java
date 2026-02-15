package Assignment;

import javax.persistence.*;

@Entity 

public class Profile {
	@Id 
	int profileId ;
	String phone ; 
	String add ;
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	} 
}
