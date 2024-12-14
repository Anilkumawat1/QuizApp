package com.anilkumawat.quiz.services;

import com.anilkumawat.quiz.dto.AnswerDto;
import com.anilkumawat.quiz.dto.QuestionDto;
import com.anilkumawat.quiz.entities.Question;
import com.anilkumawat.quiz.entities.UserSession;
import com.anilkumawat.quiz.exceptions.ResourceNotFoundException;
import com.anilkumawat.quiz.repositories.QuestionRepository;
import com.anilkumawat.quiz.repositories.UserSessionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuestionRepository questionRepository;
    private final UserSessionRepository userSessionRepository;
    private final ModelMapper modelMapper;

    public UserSession startQuiz(String username) {
        UserSession session = new UserSession(username);
        return userSessionRepository.save(session);
    }

    public QuestionDto getRandomQuestion(Long sessionId) {
        UserSession session = userSessionRepository.findById(sessionId).orElseThrow(() -> new ResourceNotFoundException("Session not found with id "+sessionId));
        return modelMapper.map(questionRepository.findRandomQuestion(),QuestionDto.class);
    }

    public AnswerDto submitAnswer(Long sessionId, Long questionId, String answer) {
        UserSession session = userSessionRepository.findById(sessionId).orElseThrow(() -> new ResourceNotFoundException("Session not found with id "+sessionId));
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new ResourceNotFoundException("Question not found with id "+questionId));

        boolean isCorrect = question.getCorrectAnswer().equals(answer);
        if (isCorrect) {
            session.incrementCorrectAnswers();
        } else {
            session.incrementIncorrectAnswers();
        }
        session.addAnsweredQuestion(question);
        userSessionRepository.save(session);
        return new AnswerDto(isCorrect ? "Correct!" : "Incorrect.");
    }

    public UserSession getSummary(Long sessionId) {
        return userSessionRepository.findById(sessionId).orElseThrow(() -> new ResourceNotFoundException("Session not found with id"+sessionId));
    }
}
