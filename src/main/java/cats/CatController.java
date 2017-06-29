package cats;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CatController {

		@Resource
		CatRepository catRepo;

		@Resource
		private GenusRepository genusRepo;
			
		@RequestMapping("/")
		public String showHomepage() {
			return "home";
		}
		
		@RequestMapping("/cats")
		public String fetchCats(Model model) {
			model.addAttribute("cats", catRepo.findAll());
			return "CatsList";
		}
		
		@RequestMapping("/cat")
		public String fetchFishDetail(@RequestParam("id") long id, Model model) {
			Cat selectedCat = catRepo.findOne(id);
			// same as model.addAttribute("fish", selectedFish)
			model.addAttribute(selectedCat);
			return "CatDetail";
		}
		@RequestMapping("/genera")
		public String fetchGenera(Model model) {
			model.addAttribute("genera", genusRepo.findAll());
			return "generaList";
		}
		
		@RequestMapping("/genus")
		public String fetchGenus(@RequestParam("id") int id, Model model) {
			model.addAttribute(genusRepo.findOne(id));
			return "genusDetail";
		}
		@RequestMapping("/addSpecies")
		public String addSpecies(@RequestParam("genusId") int id, @RequestParam("name") String newSpeciesName) {
			
			Genus selected = genusRepo.findOne(id);
			Cat newSpecies = new Cat(selected, newSpeciesName);
			catRepo.save(newSpecies);
			
			return "redirect:/genus?id=" + id;
		}
		
		@RequestMapping("/species/delete")
		public String deleteSpecies(@RequestParam("speciesId") long speciesId) {
			
			Cat toDelete = catRepo.findOne(speciesId);
			int genusId = toDelete.getGenus().getId();
			
			catRepo.delete(toDelete);
			
			return "redirect:/genus?id=" + genusId;
		}
		
}