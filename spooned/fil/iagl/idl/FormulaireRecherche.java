package fil.iagl.idl;


@lombok.Getter
@lombok.Setter
public class FormulaireRecherche {
    java.lang.String login;

    java.lang.String password;

    public boolean isCorrectlySet() {
        return ((login) != null) && ((password) != null);
    }
}

