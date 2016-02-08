package fil.iagl.idl.entite;


@lombok.Getter
@lombok.Setter
@lombok.ToString
public class Task {
    private java.lang.Integer id;

    private java.lang.String name;

    private java.lang.String description;

    private fil.iagl.idl.entite.User user;

    private java.lang.Integer state;

    private fil.iagl.idl.entite.Story story;

    private java.util.List<fil.iagl.idl.entite.Test> tests;
}

