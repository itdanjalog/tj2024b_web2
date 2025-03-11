package example.day08.model.dto;

import lombok.*;

@Setter @Getter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
public class ProductDto {
    // + 데이터베이스 테이블의 속성과 동일하게 작성
    private int id;
    private String name;
    private int price;
    private String comment;
}
