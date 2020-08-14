package com.thoughtworks.rslist.component;

import com.thoughtworks.rslist.exception.CommentError;
import com.thoughtworks.rslist.exception.InvalidParamException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({InvalidParamException.class, MethodArgumentNotValidException.class,IndexOutOfBoundsException.class})
    public ResponseEntity exceptionHandler(Exception ex){
        String errMessage;
        CommentError commentError = new CommentError();

        if (ex instanceof MethodArgumentNotValidException){
            errMessage = "invalid data";
        }else {
            errMessage = ex.getMessage();
        }
        commentError.setError(errMessage);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(commentError);
    }
}