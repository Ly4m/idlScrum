package fil.iagl.idl.controller;


@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping(value = "/test")
public class TestController {
    @org.springframework.beans.factory.annotation.Autowired
    fil.iagl.idl.service.TestService testService;

    @org.springframework.beans.factory.annotation.Autowired
    fil.iagl.idl.service.TaskService taskService;

    @org.springframework.beans.factory.annotation.Autowired
    fil.iagl.idl.service.AssociationService associationService;

    @org.springframework.web.bind.annotation.RequestMapping(value = "/refresh")
    @org.springframework.web.bind.annotation.ResponseBody
    @fil.iagl.idl.annotation.CorrespondingTask(taskName = "yolo")
    public void test() {
        try {
            fil.iagl.idl.maven.MavenRunner.cleanCompileTest(fil.iagl.idl.ScrumApplication.PATH_TO_POM);
            fil.iagl.idl.parser.Resultat res = fil.iagl.idl.parser.XMLParser.readSurefireReport(new java.io.File(((fil.iagl.idl.ScrumApplication.PATH_TO_POM) + "/target")));
            java.util.List<fil.iagl.idl.entite.Test> oldTests = testService.getAll();
            java.util.List<fil.iagl.idl.entite.Test> toAdd = new java.util.ArrayList<>();
            toAdd.addAll(res.getTests().stream().filter(( t) -> {
                for (fil.iagl.idl.entite.Test ot : oldTests) {
                    if (t.getName().equals(ot.getName())) {
                        return false;
                    } 
                }
                return true;
            }).collect(java.util.stream.Collectors.toList()));
            java.util.List<fil.iagl.idl.entite.Test> toDelete = new java.util.ArrayList<>();
            toDelete.addAll(oldTests.stream().filter(( t) -> {
                for (fil.iagl.idl.entite.Test nt : res.getTests()) {
                    if (t.getName().equals(nt.getName())) {
                        return false;
                    } 
                }
                return true;
            }).collect(java.util.stream.Collectors.toList()));
            toDelete.forEach(( t) -> associationService.deleteForTestId(t.getId()));
            toDelete.forEach(( t) -> testService.delete(t.getId()));
            toAdd.forEach(( t) -> testService.create(t));
            res.getTests().forEach(( test) -> testService.changeState(test.getId(), test.getValidate()));
            java.util.List<fil.iagl.idl.entite.Task> tasks = taskService.getAll();
            for (fil.iagl.idl.entite.Task task : tasks) {
                if (task.getTests().isEmpty()) {
                    taskService.changeState(task.getId(), fil.iagl.idl.entite.State.TODO);
                } else {
                    java.lang.Boolean isNotValid = task.getTests().stream().anyMatch(( t) -> !(t.getValidate()));
                    if (isNotValid && (task.getState().equals(fil.iagl.idl.entite.State.DONE))) {
                        taskService.changeState(task.getId(), fil.iagl.idl.entite.State.TEST_FAIL);
                    } else if (isNotValid) {
                        taskService.changeState(task.getId(), fil.iagl.idl.entite.State.DOING);
                    } else {
                        taskService.changeState(task.getId(), fil.iagl.idl.entite.State.DONE);
                    }
                }
            }
        } catch (org.xml.sax.SAXException | java.io.IOException | javax.xml.parsers.ParserConfigurationException | org.apache.maven.shared.invoker.MavenInvocationException e) {
            e.printStackTrace();
        }
    }

    @org.springframework.web.bind.annotation.RequestMapping(method = org.springframework.web.bind.annotation.RequestMethod.GET, value = "/all")
    public java.util.List<fil.iagl.idl.entite.Test> getTasks() {
        return testService.getAll();
    }
}

