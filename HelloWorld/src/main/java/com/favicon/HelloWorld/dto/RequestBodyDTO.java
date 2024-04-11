package com.favicon.HelloWorld.dto;

import lombok.Data;

@Data // Data에 Getter Setter 다 있음!
public class RequestBodyDTO {
    private int id = 2;
    private String message;
}
