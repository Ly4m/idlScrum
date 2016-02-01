package fil.iagl.idl.entite;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {

	private Integer id;
	private String login;
	private String password;
}
