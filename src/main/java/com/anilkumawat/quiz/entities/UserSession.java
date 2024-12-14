package com.anilkumawat.quiz.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "usersession")

public class UserSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private int correctAnswers;
    private int incorrectAnswers;

    @OneToMany
    private List<Question> answeredQuestions = new ArrayList<>();

    public UserSession(String username) {
        this.username = username;
    }

    // Getters and Setters

    public void incrementCorrectAnswers() {
        correctAnswers++;
    }

    public void incrementIncorrectAnswers() {
        incorrectAnswers++;
    }

    public void addAnsweredQuestion(Question question) {
        answeredQuestions.add(question);
    }
}
