package com.example.JavaEmailSender.rest;

import com.example.JavaEmailSender.entity.UserInfo;
import com.example.JavaEmailSender.service.EmailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    public static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    EmailService emailService;

    @PostMapping(path = "/sendemail")
    public ResponseEntity sendEmail(@RequestBody UserInfo userInfo) throws Exception{
        LOGGER.info("Sending Email...");

        emailService.sendEmail(userInfo);

        LOGGER.info("Email was sent...");

        return new ResponseEntity(HttpStatus.OK);
    }
}
