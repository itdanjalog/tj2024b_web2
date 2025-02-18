package example.day02._1RESTparam;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter@Setter@ToString
@AllArgsConstructor@NoArgsConstructor
public class MemberDto {
    private String name;
    private int age;
}
