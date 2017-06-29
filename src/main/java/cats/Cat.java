package cats;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cat {

    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
	private Genus genus;
	private String species;
	
	private String image;


    private Cat() {}

    public Cat(Genus genus, String species) {
    	this.genus = genus;
    	this.species = species;
    }
    	
    public Cat(Genus genus, String species, String image) {
    	this.genus = genus;
    	this.species = species;
    	this.image = image;
    }

    public Long getId() {
		return id;
	}

	public Genus getGenus() {
		return genus;
	}

	public String getSpecies() {
		return species;
	}
	
	public String getImage() {
		return image;
	}
	public boolean hasImage() {
		return image != null;
	}
	
	public String buildBinomialName() {
		return genus.getName() + " " + species;
	}

	@Override
    public String toString() {
        return String.format(
                "Customer[id=%d, genus='%s', species='%s']",
                id, genus, species);
    }

}