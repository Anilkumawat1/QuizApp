package com.anilkumawat.quiz.advices;

import com.anilkumawat.quiz.dto.ApiErrorDto;
import com.anilkumawat.quiz.dto.ApiResponseDto;
import com.anilkumawat.quiz.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponseDto<?>> ResourceNotFoundException(Exception e){
        ApiErrorDto apiErrorDto = ApiErrorDto
                .builder()
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();
        return buildErrorResponse(apiErrorDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponseDto<?>> MethodArgumentNotValidException(MethodArgumentNotValidException e){
        List<String> error = e
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());

        ApiErrorDto apiErrorDto = ApiErrorDto
                .builder()
                .status(HttpStatus.BAD_REQUEST)
                .subError(error)
                .message("Input validation failed")
                .build();

        return buildErrorResponse(apiErrorDto);

    }
    public ResponseEntity<ApiResponseDto<?>> buildErrorResponse(ApiErrorDto apiErrorDto){
        return new ResponseEntity<>(new ApiResponseDto<>(apiErrorDto), apiErrorDto.getStatus());
    }
}
