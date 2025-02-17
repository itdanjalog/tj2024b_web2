package example.day02._3실습;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class StudentDto {
    private int id;
    private String name;
    private String point;
}


