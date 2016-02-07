package fil.iagl.idl.parser;

import fil.iagl.idl.entite.Test;

import java.util.ArrayList;
import java.util.List;

public class Resultat {

    private List<Test> tests;

    public Resultat() {
        tests = new ArrayList<>();
    }

    public void addTest(Test test) {
        tests.add(test);
    }

    public List<Test> getTests() {
        return this.tests;
    }

}
