package com.minjeong.restfulapipractice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor // 매개변수가 없는 생성자
@AllArgsConstructor // 모든 필드를 매개변수로 갖는 생성자
@Data // @Getter(모든속성), @Setter(final x), @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
public class ResponseDTO {
    private String error;
    private List<String> data;
}
