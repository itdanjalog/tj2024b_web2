package example.day03._과제.model.dto;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private int bno;
    private String title;
    private String content;
}
