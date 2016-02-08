package fil.iagl.idl.maven;

import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.MavenInvocationException;

import java.io.File;
import java.util.Arrays;

public class MavenRunner {

	private static final String MAVEN_HOME_PATH = "C:/Program Files/apache-maven-3.3.9";

	public static void cleanCompileTest(String pomLocation) throws MavenInvocationException {
		InvocationRequest request = new DefaultInvocationRequest();
		request.setPomFile(new File(pomLocation));
		request.setGoals(Arrays.asList("clean", "compile", "test"));

		DefaultInvoker invoker = new DefaultInvoker();
		invoker.setMavenHome(new File(MAVEN_HOME_PATH));
		invoker.execute(request);
	}

	public static void clean(String pomLocation) throws MavenInvocationException {
		InvocationRequest request = new DefaultInvocationRequest();
		request.setPomFile(new File(pomLocation));
		request.setGoals(Arrays.asList("clean"));

		DefaultInvoker invoker = new DefaultInvoker();
		invoker.setMavenHome(new File(MAVEN_HOME_PATH));
		invoker.execute(request);
	}

}
