package cats;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genus {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private String description;
	
	@OneToMany(mappedBy="genus")
	private Set<Cat> cats;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public Set<Cat> getCats() {
		return cats;
	}
	
	// JPA needs this
	private Genus() {}
	
	public Genus(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
}
