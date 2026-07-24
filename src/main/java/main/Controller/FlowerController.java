package main.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import main.Entity.Flower;
import main.Service.FlowerService;
import main.Service.SaleService;

@Controller
public class FlowerController {
	
	 @Autowired
	    private FlowerService flowerService;
	 
	 
	 @Autowired
	 private SaleService saleService;

//	    @GetMapping("/")
//	    public String home(Model model) {
//	        model.addAttribute("flower", new Flower());
//	        model.addAttribute("flowers", flowerService.getAllFlowers());
//	        return "index";
//	    }
	 
	 
	 //dashboard  
	 
	 @GetMapping({"/", "/dashboard"})
	 public String home(Model model) {

	     model.addAttribute("flower", new Flower());
	     model.addAttribute("flowers", flowerService.getAllFlowers());

	     model.addAttribute("totalFlowers", flowerService.getTotalFlowers());
	     model.addAttribute("totalStock", flowerService.getTotalStock());
	     model.addAttribute("lowStock", flowerService.getLowStockCount());
	     model.addAttribute("inventoryValue", flowerService.getInventoryValue());

	     return "dashboard";
	 }
	 
	 
	 
	 @GetMapping("/flowers")
	 public String flowers(Model model) {

	     model.addAttribute("flower", new Flower());
	     model.addAttribute("flowers", flowerService.getAllFlowers());

	     return "flowers";
	 } 
	 
	 
	 
	 
	 
	 
	 
	 

	 
	 //flowers
	 
	 
	    @PostMapping("/saveFlower")
	    public String saveFlower(@ModelAttribute Flower flower) {
	        flowerService.saveFlower(flower);
	        return "redirect:/flowers";
	    }
	    
//	    @GetMapping("/edit/{id}")
//	    public String editFlower(@PathVariable Long id, Model model) {
//
//	        model.addAttribute("flower", flowerService.getFlowerById(id));
//	        model.addAttribute("flowers", flowerService.getAllFlowers());
//
//	        return "index";
//	    }

	    
	    
	    @GetMapping("/edit/{id}")
	    public String editFlower(@PathVariable Long id, Model model) {

	        model.addAttribute("flower", flowerService.getFlowerById(id));
	        model.addAttribute("flowers", flowerService.getAllFlowers());

//	        model.addAttribute("totalFlowers", flowerService.getTotalFlowers());
//	        model.addAttribute("totalStock", flowerService.getTotalStock());
//	        model.addAttribute("lowStock", flowerService.getLowStockCount());
//	        model.addAttribute("inventoryValue", flowerService.getInventoryValue());

	        return "flowers";
	    }
	    
	    
	    
	    @GetMapping("/delete/{id}")
	    public String deleteFlower(@PathVariable Long id) {

	        flowerService.deleteFlower(id);

	        return "redirect:/flowers";
	    }
	    
	    
	    @GetMapping("/search")
	    public String searchFlowers(@RequestParam String keyword, Model model) {

	        model.addAttribute("flower", new Flower());
	        model.addAttribute("flowers", flowerService.searchFlowers(keyword));

//	        model.addAttribute("totalFlowers", flowerService.getTotalFlowers());
//	        model.addAttribute("totalStock", flowerService.getTotalStock());
//	        model.addAttribute("lowStock", flowerService.getLowStockCount());
//	        model.addAttribute("inventoryValue", flowerService.getInventoryValue());

	        return "flowers";
	    }
	    
	    
	    @GetMapping("/stock")
	    public String stock(Model model) {

	        model.addAttribute("flowers", flowerService.getAllFlowers());

	        return "stock";
	    }
	    
	    
	    
	    @PostMapping("/updateStock")
	    public String updateStock(@RequestParam Long id,
	                              @RequestParam Integer stockQuantity) {

	        flowerService.updateStock(id, stockQuantity);

	        return "redirect:/stock";
	    }

	    
	    
	    
	    //analytics
	    
	    @GetMapping("/analytics")
	    public String analytics(Model model) {

	        model.addAttribute("totalFlowers", flowerService.getTotalFlowers());
	        model.addAttribute("totalStock", flowerService.getTotalStock());

	        model.addAttribute("totalSales", saleService.getTotalSales());
	        model.addAttribute("totalRevenue", saleService.getTotalRevenue());

	        return "analytics";
	    }
}
