package fil.iagl.idl.parser;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParser {

	public static void readSurefireReport(File sureFireReportFolder, Resultat res)
			throws SAXException, IOException, ParserConfigurationException {
		Collection<File> reports = FileUtils.listFiles(sureFireReportFolder, new String[] { "xml" }, true);
		String className = "";
		String testName = "";
		for (File report : reports) {
			Document sureFireDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(report);
			sureFireDoc.normalize();
			NodeList testsuiteNode = sureFireDoc.getElementsByTagName("testsuite");
			NodeList nList = sureFireDoc.getElementsByTagName("testcase");
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					className = element.getAttribute("classname");
					testName = element.getAttribute("name");
					System.out.println("nom : " + node.getNodeName() + " || type : " + node.getNodeType()
							+ " || Test : " + className + "." + testName);
					if (element.hasChildNodes()) {
						Node child = node.getFirstChild();
						if (child.getNodeType() == Node.ELEMENT_NODE) {
							System.out.println(child.getNodeName());
							switch (child.getNodeName()) {
							case "failure":
								System.out.println("FAIL !!!");
								break;
							case "skipped":
								System.out.println("skipped !!!");
								break;
							case "error":
								System.out.println("Error !!!");
								break;
							default:
								break;
							}
						}
					}
				}
			}
			// if (testsuiteNode.item(0).getNodeType() == Node.ELEMENT_NODE) {
			// Element eElement = (Element) testsuiteNode.item(0);
			// String className = eElement.getAttribute("name");
			// int nbTest = Integer.parseInt(eElement.getAttribute("tests"));
			// int nbError = Integer.parseInt(eElement.getAttribute("errors"));
			// int nbFailure =
			// Integer.parseInt(eElement.getAttribute("failures"));
			// int nbSkipped =
			// Integer.parseInt(eElement.getAttribute("skipped"));
			// int nbSuccess = nbTest - nbError - nbFailure - nbSkipped;
			// System.out.printf("%s\tSuccess :%d\tFailure : %d\n", className,
			// nbSuccess,
			// nbError + nbFailure + nbSkipped);
			// System.out.println("tests passés : ");
			// System.out.println("tests fail : ");
			// System.out.println("tests error : ");
			// System.out.println("tests skipped ");
			// }
		}
	}

}
