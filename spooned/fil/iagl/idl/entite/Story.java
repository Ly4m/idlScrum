package fil.iagl.idl.entite;


@lombok.Data
public class Story {
    private java.lang.Integer id;

    private java.lang.String text;

    private java.util.List<fil.iagl.idl.entite.Task> tasks;
}

