package fil.iagl.idl.maven;


public class MavenRunner {
    private static final java.lang.String MAVEN_HOME_PATH = "C:/Program Files/apache-maven-3.3.3";

    public static void cleanCompileTest(java.lang.String pomLocation) throws org.apache.maven.shared.invoker.MavenInvocationException {
        org.apache.maven.shared.invoker.InvocationRequest request = new org.apache.maven.shared.invoker.DefaultInvocationRequest();
        request.setPomFile(new java.io.File(pomLocation));
        request.setGoals(java.util.Arrays.asList("clean", "compile", "test"));
        org.apache.maven.shared.invoker.DefaultInvoker invoker = new org.apache.maven.shared.invoker.DefaultInvoker();
        invoker.setMavenHome(new java.io.File(fil.iagl.idl.maven.MavenRunner.MAVEN_HOME_PATH));
        invoker.execute(request);
    }

    public static void clean(java.lang.String pomLocation) throws org.apache.maven.shared.invoker.MavenInvocationException {
        org.apache.maven.shared.invoker.InvocationRequest request = new org.apache.maven.shared.invoker.DefaultInvocationRequest();
        request.setPomFile(new java.io.File(pomLocation));
        request.setGoals(java.util.Arrays.asList("clean"));
        org.apache.maven.shared.invoker.DefaultInvoker invoker = new org.apache.maven.shared.invoker.DefaultInvoker();
        invoker.setMavenHome(new java.io.File(fil.iagl.idl.maven.MavenRunner.MAVEN_HOME_PATH));
        invoker.execute(request);
    }
}

