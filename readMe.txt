Hello TeamCity!
Hello Michael!
Hello sara
Hello my little girl
Hello hello


How to split junit Tests in a continuous integration environement
1. maven plugin surefire
2. maven plugin failsafe
3. junit categories (since junit 4.8)
	since version 4.8, Junit comes with categories,, which is the modern way of 
	splitting unit tests, if we have the option to upgrade Junit to a new version, 
	we should use this feature for large-scale projects,
	Unlike the solutions shown before, Junit categories allow us to create a deep 
	hierarchy of unit test types, Each test can belong to multiple categories at once

	how to do that??
	Firstly, create marker interfaces, one for each category, 
	public interface IntegrationTests {}
	public interface OrdinaryTests {}
	public interface SmokeTests {}
	
	secondly, create testing class and adding @Category(IntegrationTests.class) 
	
	lastly, we can now select which categories we want to run on the command line by passing the groups parameter to maven executable 
	mvn test -Dgroups="test.OrdinaryTests"
	mvn test -Dgroups="test.IntegrationTests"
	
	Alternatively, we can set up the category directly in the pom.xml file
	
	<plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>2.19.1</version>
        <configuration>
            <groups>com.codepipes.Fast</groups>
        </configuration>
    </plugin>
	
	The XML groups element is supported by both the surefire plugin, and the failsafe plugin. 
	This allows us to gradually move to JUnit categories, even if we've already used the failsafe plugin for integration tests.
	
	A large-scale enterprise project will often require a lot of JUnit categories. A valid scenario is to start with surefire exclusions
	 at the inception of the code, adopt the failsafe plugin once the test/staging environment is active, and finally employ JUnit categories
	  as the project nears completion status.
	
	
https://semaphoreci.com/community/tutorials/how-to-split-junit-tests-in-a-continuous-integration-environment


