package fil.iagl.idl.entite;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Task {

	private Integer id;

	private String name;

	private String description;

	private User user;

	private Integer state;

	private Story story;

	private List<Test> tests;

}
