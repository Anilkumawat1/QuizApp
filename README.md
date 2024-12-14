# Quiz App API

## Overview
This is a simple Quiz App API developed using Spring Boot. It allows users to:
1. Start a new quiz session.
2. Retrieve a random multiple-choice question.
3. Submit an answer.
4. Get quiz statistics, including the number of questions answered and details on correct and incorrect submissions.

### Assumptions
- A single user is seeded in the database for simplicity.
- The API does not include user management features (e.g., registration, login).
- The application uses an in-memory H2 database for storing questions and answers.
- Some questions are pre-seeded in the database during initialization.
- Only one active quiz session per user is supported.

## API Endpoints

### port - 8080

### 1. Start a New Quiz Session
**Endpoint**: `POST /api/quiz/start`

**Description**: Starts a new quiz session for the user.

**Request body**:
anil

**Response**:
```json
{
    "timeStamp": "2024-12-14T20:44:25.713759",
    "apiErrorDto": null,
    "data": {
        "id": 1,
        "username": "anil",
        "correctAnswers": 0,
        "incorrectAnswers": 0,
        "answeredQuestions": []
    }
}
```
### 2. Get a Random Question
**Endpoint**: `GET /api/quiz/question?sessionId=1`

**Description**: Retrieves a random multiple-choice question from the database.

**Response**:
```json
{
    "timeStamp": "2024-12-14T20:54:19.720501",
    "apiErrorDto": null,
    "data": {
        "id": 14,
        "questionText": "Which continent is the largest?",
        "optionA": "Africa",
        "optionB": "Asia",
        "optionC": "Europe",
        "optionD": "North America"
    }
}
```
### 3. Submit an Answer
**Endpoint**: POST /api/quiz/answer?sessionId=1&questionId=14&answer=North America

**Description**: Submits an answer for a question.

**Response**:
```json
{
    "timeStamp": "2024-12-14T20:59:26.681441",
    "apiErrorDto": null,
    "data": {
        "answer": "Incorrect."
    }
}
```
### 4. Get Quiz Summary
**Endpoint**: GET /api/quiz/summary?sessionId=1

**Description**: Retrieves the questions answered, with details on correct and incorrect submissions.

Response:
```
{
    "timeStamp": "2024-12-14T21:03:21.730331",
    "apiErrorDto": null,
    "data": {
        "id": 1,
        "username": "anil",
        "correctAnswers": 1,
        "incorrectAnswers": 1,
        "answeredQuestions": [
            {
                "id": 14,
                "questionText": "Which continent is the largest?",
                "optionA": "Africa",
                "optionB": "Asia",
                "optionC": "Europe",
                "optionD": "North America",
                "correctAnswer": "Asia"
            },
            {
                "id": 19,
                "questionText": "Who is known as the Father of Computers?",
                "optionA": "Charles Babbage",
                "optionB": "Alan Turing",
                "optionC": "John von Neumann",
                "optionD": "Steve Jobs",
                "correctAnswer": "Charles Babbage"
            }
        ]
    }
}
