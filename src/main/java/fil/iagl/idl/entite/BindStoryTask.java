package fil.iagl.idl.entite;

import lombok.Data;

@Data
public class BindStoryTask {

    private Integer id;

    private Story   story;

    private Task    task;

}
