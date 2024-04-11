package com.minjeong.restfulapipractice.dto;

import lombok.Data;

@Data // Data에 Getter Setter 다 있음!
public class RequestBodyDTO {
    private int std_id;
    private String name;
}
