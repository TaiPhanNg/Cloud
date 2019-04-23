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
import com.QuanLyNhanSu.model.Projects;
import com.QuanLyNhanSu.service.ProjectsService;

@Controller
public class ProjectsController {
	@Autowired
	private ProjectsService projectsService;
	
	@GetMapping("/projects")
	public String index(Model model) {
		model.addAttribute("projects", projectsService.findAll());
		return "listpr";
	}

	@GetMapping("/projects/create")
	public String create(Model model) {
		model.addAttribute("projects", new Projects());
		return "formpr";
	}

	@GetMapping("/projects/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("projects", projectsService.findById(id));
		return "formpr";
	}

	@PostMapping("/projects/save")
	public String save(@Valid Projects projects, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "formpr";
		}
		projectsService.save(projects);
		redirect.addFlashAttribute("success", "Saved project successfully!");
		return "redirect:/projects";
	}

	@GetMapping("/projects/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		projectsService.delete(id);
		redirect.addFlashAttribute("success", "Deleted project successfully!");
		return "redirect:/projects";
	}

	@GetMapping("/projects/search")
	public String search(@RequestParam("s") String s, Model model) {
		if (s.equals("")) {
			return "redirect:/projects";
		}

		model.addAttribute("projects", projectsService.search(s));
		return "listpr";
	}
}
