package Assignment;
import javax.persistence.*;
@Entity 
@Table 
public class Hostel {
	@Id
	@Column (name = "Hostel_id")
	int id ;
	double price ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
