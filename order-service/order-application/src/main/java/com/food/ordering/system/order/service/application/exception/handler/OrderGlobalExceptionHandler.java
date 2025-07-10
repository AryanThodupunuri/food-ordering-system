package com.food.ordering.system.order.service.application.exception.handler;

import com.food.ordering.system.application.handler.ErrorDTO;
import com.food.ordering.system.application.handler.GlobalExceptionHandler;
import com.food.ordering.system.order.service.domain.exception.OrderDomainException;
import com.food.ordering.system.order.service.domain.exception.OrderNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class OrderGlobalExceptionHandler extends GlobalExceptionHandler {

    // Handles general domain-related exceptions that occur within the Order Service.
    // These typically involve validation or business logic violations.
    @ResponseBody
    @ExceptionHandler(value = {OrderDomainException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleException(OrderDomainException orderDomainException) {
        log.error(orderDomainException.getMessage(), orderDomainException);
        return ErrorDTO.builder()
                .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(orderDomainException.getMessage())
                .build();
    }

    // Handles cases where an order is not found in the system (e.g., querying by invalid ID).
    @ResponseBody
    @ExceptionHandler(value = {OrderNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(OrderNotFoundException orderNotFoundException) {
        log.error(orderNotFoundException.getMessage(), orderNotFoundException);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(orderNotFoundException.getMessage())
                .build();
    }
}


