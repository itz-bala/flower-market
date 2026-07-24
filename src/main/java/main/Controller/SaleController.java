package main.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import main.Entity.Sale;
import main.Service.FlowerService;
import main.Service.SaleService;

@Controller
public class SaleController {
	
	
	
	
	@Autowired
    private SaleService saleService;
	
	@Autowired
	private FlowerService flowerService;

//    @GetMapping("/sales")
//    public String sales(Model model){
//
//        model.addAttribute("sale",new Sale());
//        model.addAttribute("sales",saleService.getAllSales());
//
//        return "sales";
//
//    }
	
	
	
	@GetMapping("/sales")
	public String sales(Model model){

	    model.addAttribute("sale", new Sale());

	    model.addAttribute("sales", saleService.getAllSales());

	    model.addAttribute("flowers", flowerService.getAllFlowers());

	    return "sales";
	}
	
	

    @PostMapping("/saveSale")
    public String saveSale(@ModelAttribute Sale sale){

        saleService.saveSale(sale);

        return "redirect:/sales";

    }
	

}
