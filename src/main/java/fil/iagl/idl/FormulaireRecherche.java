package fil.iagl.idl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormulaireRecherche {

    String login;

    String password;

    public boolean isCorrectlySet() {
        return login != null && password != null;
    }
}
