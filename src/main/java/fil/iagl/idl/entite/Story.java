package fil.iagl.idl.entite;

import java.util.List;

import lombok.Data;

@Data
public class Story {

    private Integer      id;

    private String       text;

    private List< Task > tasks;
}
