package com.jforce.feedback.controller;

import com.jforce.feedback.entity.JForceUser;
import com.jforce.feedback.service.AdminService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public String dashboard(HttpSession session, Model model) {

        if (!isAdmin(session)) return "redirect:/login";
        model.addAttribute("feedbacks", adminService.listFeedbacks());

        return "admin";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, HttpSession session, Model model) {

        if (!isAdmin(session)) return "redirect:/login";


        model.addAttribute("feedback", adminService.findFeedbackById(id));

        return "admin-form";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id,
                         @RequestParam String content,
                         HttpSession session) {

        if (!isAdmin(session)) return "redirect:/login";

        adminService.updateFeedback(id, content);

        return "redirect:/admin";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, HttpSession session) {

        if (!isAdmin(session)) return "redirect:/login";

        adminService.deleteById(id);

        return "redirect:/admin";
    }

    private boolean isAdmin(HttpSession session) {
        JForceUser user = (JForceUser) session.getAttribute("user");
        return user != null && "ADMIN".equals(user.getRole());
    }
}
