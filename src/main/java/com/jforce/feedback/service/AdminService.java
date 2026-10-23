package com.jforce.feedback.service;

import com.jforce.feedback.entity.Feedback;
import com.jforce.feedback.repository.FeedbackRepository;
import com.jforce.feedback.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final FeedbackRepository feedbackRepository;
    private final UserRepository userRepository;

    public AdminService(FeedbackRepository feedbackRepository, UserRepository userRepository) {
        this.feedbackRepository = feedbackRepository;
        this.userRepository = userRepository;
    }

    public List<Feedback> listFeedbacks() {
        return feedbackRepository.findAll();
    }

    public void deleteById(Long id) {
        feedbackRepository.deleteById(id);
    }

    public void updateFeedback(Long id, String content) {
        Feedback feedback = feedbackRepository.findById(id).orElseThrow();
        feedback.setContent(content);
        feedbackRepository.save(feedback);
    }

    public Feedback findFeedbackById(Long id) {
        return feedbackRepository.findById(id).orElse(null);
    }
}
