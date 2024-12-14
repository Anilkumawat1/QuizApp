package com.anilkumawat.quiz.controllers;

import com.anilkumawat.quiz.dto.AnswerDto;
import com.anilkumawat.quiz.dto.QuestionDto;
import com.anilkumawat.quiz.entities.UserSession;
import com.anilkumawat.quiz.services.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;

    @PostMapping("/start")
    public ResponseEntity<UserSession> startQuiz(@RequestBody String username) {
        UserSession session = quizService.startQuiz(username);
        return ResponseEntity.ok(session);
    }

    @GetMapping("/question")
    public ResponseEntity<QuestionDto> getRandomQuestion(@RequestParam Long sessionId) {
        System.out.println(sessionId+" "+"-----------------------");
        QuestionDto question = quizService.getRandomQuestion(sessionId);
        System.out.println(question.toString());
        return ResponseEntity.ok(question);
    }

    @PostMapping("/answer")
    public ResponseEntity<AnswerDto> submitAnswer(@RequestParam Long sessionId, @RequestParam Long questionId, @RequestParam String answer) {
        AnswerDto result = quizService.submitAnswer(sessionId, questionId, answer);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/summary")
    public ResponseEntity<UserSession> getQuizSummary(@RequestParam Long sessionId) {
        UserSession summary = quizService.getSummary(sessionId);
        return ResponseEntity.ok(summary);
    }
}
