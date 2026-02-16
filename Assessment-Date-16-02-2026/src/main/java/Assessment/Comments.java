package Assessment;

import javax.persistence.*;

@Entity

public class Comments {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator ="numbers")
	@SequenceGenerator(name="numbers" , sequenceName = "number_sequence" , initialValue = 1000 , allocationSize = 1) 
	int id ;
	String content ; 
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@ManyToOne
	private Post p ; 
	public Post getPost() {
		return p  ; 
	}
	public void setPost(Post p) {
		this.p = p ;
	}
	@ManyToOne
	private Users u ; 
	public Users getUser() {
		return u ; 
	}
	public void setUser(Users u) {
		this.u = u ; 
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Post getP() {
		return p;
	}
	public void setP(Post p) {
		this.p = p;
	}
	public Users getU() {
		return u;
	}
	public void setU(Users u) {
		this.u = u;
	}
	public String toString() {
		return id + " " + content ;
	}
}
