package com.jforce.feedback.entity;

import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 2000)
    private String content;

    @Column(name = "created_at", nullable = false)
    private ZonedDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private JForceUser user;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public JForceUser getUser() { return user; }
    public void setUser(JForceUser user) { this.user = user; }

    public ZonedDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(ZonedDateTime createdAt) { this.createdAt = createdAt; }

}