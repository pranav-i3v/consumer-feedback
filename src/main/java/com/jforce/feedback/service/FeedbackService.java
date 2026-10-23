package com.jforce.feedback.service;

import com.jforce.feedback.entity.Feedback;
import com.jforce.feedback.entity.JForceUser;
import com.jforce.feedback.exception.FeedbackNotFoundException;
import com.jforce.feedback.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public Optional<Feedback> getFeedbackByUserId(Long id) {
        return feedbackRepository.findByUserId(id);
    }

    public void updateFeedback(Long id, String content) {

        Feedback feedback = feedbackRepository.findById(id)
                .orElseThrow(() -> new FeedbackNotFoundException("Feedback not found"));
        feedback.setContent(content);
        feedbackRepository.save(feedback);
    }

    public void createFeedback(JForceUser user , String content) {
        Feedback feedback = new Feedback();
        feedback.setUser(user);
        feedback.setCreatedAt(ZonedDateTime.now(ZoneId.of("America/Chicago")));
        feedback.setContent(content);
        feedbackRepository.save(feedback);
    }
}
