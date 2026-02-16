package Assessment;

import javax.persistence.*;
import java.util.*;

@Entity 


public class Post {
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="number") 
	@SequenceGenerator(name="number" , sequenceName = "number_seq"  , initialValue = 100 , allocationSize = 1) 
	int id ; 
	String title ;
	String content ;
	@ManyToOne 
	private Users u ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@OneToMany
	private List<Comments> list ; 
	public List<Comments> getComments(){
		return list ;
	}
	public void setComments(List<Comments> list) {
		this.list = list  ; 
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Users getU() {
		return u;
	}
	public void setU(Users u) {
		this.u = u;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + "]";
	} 
	
}
