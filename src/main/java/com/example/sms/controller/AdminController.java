package com.example.sms.controller;

import com.example.sms.entity.Admin;
import com.example.sms.entity.Student;
import com.example.sms.service.AdminServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
    private AdminServices adminServices;

    public AdminController(AdminServices adminServices) {
        super();
        this.adminServices = adminServices;
    }

    //	save student
    @PostMapping("/login")
    public String loginAdminForm(@ModelAttribute("email") String email, @ModelAttribute("password") String password) {
        Admin admin = adminServices.getAdminByEmail(email,password);
        if(admin!=null) return "redirect:/students";
        return "index";
    }
    
    @GetMapping("/login")
    public ModelAndView login() {
    	ModelAndView mav = new ModelAndView("index");
    	mav.addObject("admin", new Admin());
        return mav;
    }
    
    @GetMapping("/logout")
    public ModelAndView logout() {
    	ModelAndView mav = new ModelAndView("index");
    	mav.addObject("admin", new Admin());
        return mav;
    }

    //	add admin
    @PostMapping("/admins/new")
    public String createAdminForm(Model model) {
        // created admin object to hold admin form data
        Admin admin = new Admin();
        model.addAttribute("admin", admin);
        return "redirect:/students";
    }
    
	@PostMapping("/admins")
	public String saveStudent(@ModelAttribute("admin") Admin admin) {
		adminServices.saveAdmin(admin);
		return "redirect:/students";
	}
}