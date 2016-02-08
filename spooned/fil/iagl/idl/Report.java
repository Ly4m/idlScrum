package fil.iagl.idl;


@lombok.Data
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
public class Report {
    private java.lang.String type;

    private fil.iagl.idl.Value value;
}

