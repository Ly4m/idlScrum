package fil.iagl.idl.parser;


public class Resultat {
    private java.util.List<fil.iagl.idl.entite.Test> tests;

    public Resultat() {
        tests = new java.util.ArrayList<>();
    }

    public void addTest(fil.iagl.idl.entite.Test test) {
        tests.add(test);
    }

    public java.util.List<fil.iagl.idl.entite.Test> getTests() {
        return fil.iagl.idl.parser.Resultat.this.tests;
    }
}

