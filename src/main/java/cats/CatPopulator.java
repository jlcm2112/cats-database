package cats;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CatPopulator implements CommandLineRunner {

	@Resource
	private CatRepository catRepo;
	
	@Resource
	private GenusRepository genusRepo;
	
	@Override
	public void run(String... args) throws Exception {
		Genus panthera = new Genus("Panthera", "Panthera is a genus within the Felidae family that was named and first described by the German naturalist Oken in 1816. "); 
		genusRepo.save(panthera);
		Cat cat = new Cat(panthera, "Leo", "panthera-leo.jpg");
		catRepo.save(cat);
		
		Genus felis = new Genus("Felis", "Felis is a genus of small and medium-sized cat species native to most of Africa and south of 60° latitude in Europe and Asia to Indochina.");
		genusRepo.save(felis);
		catRepo.save(new Cat(felis, "Catus"));
	}

}