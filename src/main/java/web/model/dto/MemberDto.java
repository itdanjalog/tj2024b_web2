package web.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
// @Data → Getter, Setter, toString() 자동 생성
//@AllArgsConstructor → 모든 필드를 포함한 생성자 자동 생성
//@NoArgsConstructor → 기본 생성자 자동 생성
public class MemberDto {
    private int mno;
    private String mid;
    private String mpwd;
    private String mname;
    private String mimg;
    private MultipartFile uploadfile;
}
