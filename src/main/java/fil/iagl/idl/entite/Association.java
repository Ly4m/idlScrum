package fil.iagl.idl.entite;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Association {

	private Integer id;
	private Task task;
	private Test test;
}
