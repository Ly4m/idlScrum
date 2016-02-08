package fil.iagl.idl.entite;


@lombok.Getter
@lombok.ToString
public enum State {
TODO(1), DOING(2), DONE(3), TEST_FAIL(4);
    private java.lang.Integer id;
    State(java.lang.Integer id) {
        fil.iagl.idl.entite.State.this.id = id;
    }
    public java.lang.Integer getId() {
        return id;
    }
}

