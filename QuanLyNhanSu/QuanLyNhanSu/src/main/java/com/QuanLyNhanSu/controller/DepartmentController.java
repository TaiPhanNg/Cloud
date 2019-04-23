package com.QuanLyNhanSu.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.QuanLyNhanSu.model.Department;
import com.QuanLyNhanSu.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/department")
	public String index(Model model) {
		model.addAttribute("departments", departmentService.findAll());
		return "listdpm";
	}

	@GetMapping("/department/create")
	public String create(Model model) {
		model.addAttribute("department", new Department());
		return "formdpm";
	}

	@GetMapping("/department/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("department", departmentService.findById(id));
		return "formdpm";
	}

	@PostMapping("/department/save")
	public String save(@Valid Department department, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "formdpm";
		}
		departmentService.save(department);
		redirect.addFlashAttribute("success", "Saved department successfully!");
		return "redirect:/department";
	}

	@GetMapping("/department/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		departmentService.delete(id);
		redirect.addFlashAttribute("success", "Deleted department successfully!");
		return "redirect:/department";
	}

	@GetMapping("/department/search")
	public String search(@RequestParam("s") String s, Model model) {
		if (s.equals("")) {
			return "redirect:/department";
		}

		model.addAttribute("departments", departmentService.search(s));
		return "listdpm";
	}
}
