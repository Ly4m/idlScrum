package fil.iagl.idl.entite;


@lombok.Getter
@lombok.Setter
@lombok.ToString
public class Test {
    private java.lang.Integer id;

    private java.lang.String name;

    private java.lang.Boolean validate;

    public Test() {
    }

    public Test(java.lang.String name ,java.lang.Boolean validate) {
        fil.iagl.idl.entite.Test.this.name = name;
        fil.iagl.idl.entite.Test.this.validate = validate;
    }
}

