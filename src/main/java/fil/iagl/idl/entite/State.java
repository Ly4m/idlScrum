package fil.iagl.idl.entite;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum State {
	TODO(1), DOING(2), DONE(3), TEST_FAIL(4);

	private Integer id;

	State(Integer id) {
		this.id = id;
	}
}
