package hmrcb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private Integer id;
    private String name;
    private Boolean gender;
    @DateTimeFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private Date birth;
    private Integer age;

}
