package fil.iagl.idl.parser;


public class XMLParser {
    public static fil.iagl.idl.parser.Resultat readSurefireReport(java.io.File sureFireReportFolder) throws java.io.IOException, javax.xml.parsers.ParserConfigurationException, org.xml.sax.SAXException {
        fil.iagl.idl.parser.Resultat res = new fil.iagl.idl.parser.Resultat();
        java.util.Collection<java.io.File> reports = org.apache.commons.io.FileUtils.listFiles(sureFireReportFolder, new java.lang.String[]{ "xml" }, true);
        java.lang.String className = "";
        java.lang.String testName = "";
        for (java.io.File report : reports) {
            org.w3c.dom.Document sureFireDoc = javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(report);
            sureFireDoc.normalize();
            org.w3c.dom.NodeList testsuiteNode = sureFireDoc.getElementsByTagName("testsuite");
            org.w3c.dom.NodeList nList = sureFireDoc.getElementsByTagName("testcase");
            for (int i = 0 ; i < (nList.getLength()) ; i++) {
                org.w3c.dom.Node node = nList.item(i);
                if ((node.getNodeType()) == (org.w3c.dom.Node.ELEMENT_NODE)) {
                    org.w3c.dom.Element element = ((org.w3c.dom.Element)(node));
                    className = element.getAttribute("classname");
                    testName = element.getAttribute("name");
                    if (element.hasChildNodes()) {
                        org.w3c.dom.Node child = node.getFirstChild();
                        if ((child.getNextSibling()) != null) {
                            fil.iagl.idl.entite.Test test = new fil.iagl.idl.entite.Test(((className + ".") + testName) , false);
                            switch (child.getNextSibling().getNodeName()) {
                                case "failure" :
                                    res.addTest(test);
                                    break;
                                case "skipped" :
                                    res.addTest(test);
                                    break;
                                case "error" :
                                    res.addTest(test);
                                    break;
                                default :
                                    break;
                            }
                        } 
                    } else {
                        fil.iagl.idl.entite.Test test = new fil.iagl.idl.entite.Test(((className + ".") + testName) , true);
                        res.addTest(test);
                    }
                } 
            }
        }
        return res;
    }
}

