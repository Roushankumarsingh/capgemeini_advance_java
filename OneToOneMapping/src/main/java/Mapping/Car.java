package Mapping;
import javax.persistence.* ;



@Entity 
public class Car {
	@Id
	private int id ; 
	private String brand ; 
	private String color ;  
	private String model ;
	private String modelYear ; 
	private double price  ;
	
	@OneToOne // to create foreign key we use @OneToOne wihtout this it will throw an error 
	private Engine engine ; // this will act as a foreign key 
	public Engine getEngine() {
		return engine ; 
	}
	
	public void setEngine(Engine engine) {
		this.engine = engine ; 
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getModelYear() {
		return modelYear;
	}
	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	} 
	public String toString() {
		return id + " " + brand + " " + color + " " +  model  + " " + modelYear + " " + price ; 
	}
}
