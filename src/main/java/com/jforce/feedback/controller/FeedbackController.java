package com.jforce.feedback.controller;

import com.jforce.feedback.entity.Feedback;
import com.jforce.feedback.entity.JForceUser;
import com.jforce.feedback.service.FeedbackService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/feedback")
    public String feedbackPage(@RequestParam(defaultValue = "add") String mode,
                               HttpSession session,
                               Model model) {

        JForceUser user = (JForceUser) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        Optional<Feedback> existing = feedbackService.getFeedbackByUserId(user.getId());
        model.addAttribute("mode", mode);

        if ("edit".equals(mode)) {
            if (existing.isPresent()) {
                model.addAttribute("content", existing.get().getContent());
            } else {
                model.addAttribute("message", "No feedback submitted yet. Please add new feedback.");
            }
        } else if (existing.isPresent()) {
            model.addAttribute("message", "You have already submitted feedback. Use Edit Feedback to change it.");
        }
        return "feedback";
    }

    @PostMapping("/feedback")
    public String submitFeedback(@RequestParam String mode,
                                 @RequestParam String content,
                                 HttpSession session) {
        JForceUser user = (JForceUser) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        Optional<Feedback> existing = feedbackService.getFeedbackByUserId(user.getId());

        if ("edit".equals(mode)) {
            if (existing.isEmpty()) {
                return "redirect:/feedback?mode=add";
            }

            feedbackService.updateFeedback(existing.get().getId(), content);
            return "redirect:/feedback?mode=edit&success=true";
        }

        if (existing.isPresent()) {
            return "redirect:/feedback?mode=edit";
        }

        feedbackService.createFeedback(user, content);
        return "redirect:/feedback?mode=edit&success=true";
    }
}
