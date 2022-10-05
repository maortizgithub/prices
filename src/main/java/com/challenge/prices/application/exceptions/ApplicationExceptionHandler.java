package com.challenge.prices.application.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    private final ApplicationContext context;

    public ApplicationExceptionHandler(ApplicationContext context) {
        this.context = context;
    }

    @ExceptionHandler(value = ApplicationException.class)
    public ResponseEntity<Object> applicationException(
            ApplicationException exception, WebRequest request) {
        log.error(exception.getMessage());
        exception.getErrorDto().setPath(getDescription(request));
        return ResponseEntity.status(exception.getStatus()).body(exception.getErrorDto());
    }

    /**
     * Path where the exception occurs
     *
     * @param request
     * @return
     */
    private String getDescription(WebRequest request) {
        return request.getDescription(Boolean.FALSE).replace("uri=", "");
    }
}
