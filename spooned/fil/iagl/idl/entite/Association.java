package fil.iagl.idl.entite;


@lombok.Getter
@lombok.Setter
@lombok.ToString
public class Association {
    private java.lang.Integer id;

    private fil.iagl.idl.entite.Task task;

    private fil.iagl.idl.entite.Test test;
}

