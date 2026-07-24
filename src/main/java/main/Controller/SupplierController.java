package main.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import main.Entity.Supplier;
import main.Service.SupplierService;

@Controller
public class SupplierController {
	
	
	 @Autowired
	    private SupplierService supplierService;

	    @GetMapping("/suppliers")
	    public String suppliers(Model model) {

	        model.addAttribute("supplier", new Supplier());
	        model.addAttribute("suppliers", supplierService.getAllSuppliers());

	        return "suppliers";
	    }

	    @PostMapping("/saveSupplier")
	    public String saveSupplier(@ModelAttribute Supplier supplier) {

	        supplierService.saveSupplier(supplier);

	        return "redirect:/suppliers";
	    }

	    @GetMapping("/deleteSupplier/{id}")
	    public String deleteSupplier(@PathVariable Long id) {

	        supplierService.deleteSupplier(id);

	        return "redirect:/suppliers";
	    }

}
