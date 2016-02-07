package fil.iagl.idl.entite;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Test {

    private Integer id;
    private String name;
    private Boolean validate;

    public Test(){

    }

    public Test(String name, Boolean validate) {
        this.name = name;
        this.validate = validate;
    }
}
