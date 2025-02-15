package com.example.jmsrabbitmq.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactUsForm {
    private String name;
    private String email;
    private String subject;
    private String message;
}
