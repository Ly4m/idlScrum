package fil.iagl.idl.controller;

import fil.iagl.idl.ScrumApplication;
import fil.iagl.idl.entite.Test;
import fil.iagl.idl.maven.MavenRunner;
import fil.iagl.idl.parser.Resultat;
import fil.iagl.idl.parser.XMLParser;
import fil.iagl.idl.service.TestService;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;



    @RequestMapping("/refresh")
    @ResponseBody
    public void test() {
        try {
            MavenRunner.cleanCompileTest(ScrumApplication.PATH_TO_POM);
            Resultat res = XMLParser.readSurefireReport(new File(ScrumApplication.PATH_TO_POM + "/target"));
            testService.deleteAll();
            res.getTests().forEach(test -> testService.create(test));
        } catch (SAXException | IOException | ParserConfigurationException | MavenInvocationException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.GET,  value = "/all")
    public List<Test> getTasks() {
        return testService.getAll();
    }

}
