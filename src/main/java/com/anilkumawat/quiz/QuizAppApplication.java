package com.anilkumawat.quiz;

import com.anilkumawat.quiz.entities.Question;
import com.anilkumawat.quiz.repositories.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QuizAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(QuizAppApplication.class, args);

	}
	@Bean
	public CommandLineRunner initializeDatabase(QuestionRepository questionRepository) {
		return args -> {
			questionRepository.save(new Question(null, "What is the capital of France?", "Berlin", "Madrid", "Paris", "Rome", "Paris"));
			questionRepository.save(new Question(null, "Which planet is known as the Red Planet?", "Earth", "Mars", "Jupiter", "Saturn", "Mars"));
			questionRepository.save(new Question(null, "Who wrote 'To Kill a Mockingbird'?", "Harper Lee", "J.K. Rowling", "Ernest Hemingway", "Mark Twain", "Harper Lee"));
			questionRepository.save(new Question(null, "What is the chemical symbol for water?", "H2O", "CO2", "NaCl", "O2", "H2O"));
			questionRepository.save(new Question(null, "What is the largest mammal?", "Elephant", "Blue Whale", "Giraffe", "Great White Shark", "Blue Whale"));
			questionRepository.save(new Question(null, "Which is the smallest planet in the Solar System?", "Mercury", "Venus", "Mars", "Pluto", "Mercury"));
			questionRepository.save(new Question(null, "Who painted the Mona Lisa?", "Vincent van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Claude Monet", "Leonardo da Vinci"));
			questionRepository.save(new Question(null, "In which year did the Titanic sink?", "1910", "1912", "1914", "1916", "1912"));
			questionRepository.save(new Question(null, "What is the capital of Japan?", "Beijing", "Seoul", "Bangkok", "Tokyo", "Tokyo"));
			questionRepository.save(new Question(null, "Which gas do plants absorb for photosynthesis?", "Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen", "Carbon Dioxide"));
			questionRepository.save(new Question(null, "What is the square root of 144?", "10", "12", "14", "16", "12"));
			questionRepository.save(new Question(null, "Who discovered penicillin?", "Alexander Fleming", "Marie Curie", "Isaac Newton", "Charles Darwin", "Alexander Fleming"));
			questionRepository.save(new Question(null, "Which country is known as the Land of the Rising Sun?", "China", "South Korea", "Japan", "Thailand", "Japan"));
			questionRepository.save(new Question(null, "Which continent is the largest?", "Africa", "Asia", "Europe", "North America", "Asia"));
			questionRepository.save(new Question(null, "What is the boiling point of water?", "90°C", "100°C", "120°C", "150°C", "100°C"));
			questionRepository.save(new Question(null, "Who developed the theory of relativity?", "Isaac Newton", "Albert Einstein", "Galileo Galilei", "Nikola Tesla", "Albert Einstein"));
			questionRepository.save(new Question(null, "Which is the longest river in the world?", "Amazon", "Nile", "Yangtze", "Mississippi", "Nile"));
			questionRepository.save(new Question(null, "What is the capital of Australia?", "Sydney", "Melbourne", "Canberra", "Brisbane", "Canberra"));
			questionRepository.save(new Question(null, "Who is known as the Father of Computers?", "Charles Babbage", "Alan Turing", "John von Neumann", "Steve Jobs", "Charles Babbage"));
			questionRepository.save(new Question(null, "Which planet has the most moons?", "Earth", "Saturn", "Jupiter", "Mars", "Saturn"));
		};
	}


}
