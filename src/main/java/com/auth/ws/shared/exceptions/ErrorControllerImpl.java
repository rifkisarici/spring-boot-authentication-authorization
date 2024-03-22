package com.auth.ws.shared.exceptions;

import com.auth.ws.shared.responses.ApiError;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
public class ErrorControllerImpl implements ErrorController {

    private final ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    public ApiError handleError(WebRequest webRequest) {
        Map<String, Object> attributes = this.errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE, ErrorAttributeOptions.Include.BINDING_ERRORS));
        int status = (int) attributes.get("status");
        String message = attributes.get("message").toString();
        String path = attributes.get("path").toString();

        ApiError apiError = new ApiError(status, message, path);

        if (attributes.containsKey("errors")) {
            @SuppressWarnings("unchecked")
            List<FieldError> fieldErrors = (List<FieldError>) attributes.get("errors");

            Map<String, String> validationErrors = new HashMap<>();
            fieldErrors.forEach(fieldError -> validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage()));
            apiError.setValidationErrors(validationErrors);
        }

        return apiError;
    }
}
