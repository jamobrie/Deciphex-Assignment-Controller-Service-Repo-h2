package com.deciphex.deciphex.assignment.exception;

import com.deciphex.deciphex.assignment.StudyApplication;
import com.deciphex.deciphex.assignment.models.Descriptor;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandling {

    private static final Logger logger = LoggerFactory.getLogger(StudyApplication.class);

    private static final String HELP_URL = "www.fakeWebsiteToVisitForMoreHelp";

    @ResponseBody
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public List<Descriptor> handleInvalidTeammateException(Exception ex) {
        logger.error("Error occurred due to bad data in relation to request body");

        Descriptor descriptor = new Descriptor();
        descriptor.setCode("BAD DATA ERROR");
        descriptor.setMessage(ex.getMessage());
        descriptor.setHelpUrl(HELP_URL);
        descriptor.setTraceId("");

        List<Descriptor> descriptorList = new ArrayList<>();
        descriptorList.add(descriptor);

        return descriptorList;
    }

}
