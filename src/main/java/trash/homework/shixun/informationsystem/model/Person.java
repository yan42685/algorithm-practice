package trash.homework.shixun.informationsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    protected String id;
    protected String name;
    protected String age;
    protected String birthday;
}
