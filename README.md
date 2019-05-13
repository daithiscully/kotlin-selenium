# Automated testing framework with Kotlin

## Requirements:
- [Kotlin](https://kotlinlang.org/docs/tutorials/command-line.html) (version is >= 1.3.31)
- [Maven](https://maven.apache.org/download.cgi) (version is >= 3.3.9)
- A Selenium Grid running with at least Chrome and Firefox nodes setup, see [Set up Selenium Grid 
with Docker](#set-up-selenium-grid-with-docker) section below. This approach will require Docker to 
be installed and a Docker Swarm initialised)
- [Allure CLI](https://docs.qameta.io/allure/) for report viewing and generation (optional)
- Internet connection to download the project dependencies (via Maven)

## Download the Allure commandline tool from Maven Central:
- [TAR Download](http://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/2.10.0/allure-commandline-2.10.0.tgz)

- [ZIP download](http://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/2.10.0/allure-commandline-2.10.0.zip)

# Example Selenium testing with Kotlin
This project is an example of how one would setup a Selenium testing project with Kotlin.
This project uses Maven as the Build tool where we can utilize the `test` lifecycle to run our 
End-to-End tests (`mvn clean test`).

## Set up Selenium Grid with Docker
Located in the root of this project is a docker file for use in a Swarm configuration.

1. To start Docker in Swarm mode, you need to run `docker swarm init` (may require the --advertise-addr flag to be set)
2. To deploy the Grid: `docker stack deploy -c selenium-docker-stack.yml grid`
3. Stop with: `docker stack rm grid`

This will create a Selenium Hub where the test code will attempt to create browser instances. See 
[SetUpSelenideListener.java](src/test/kotlin/com/scully/SetUpSelenideListener.java) for setting 
this value. The URL for the Hub can be abstracted to pom file and specified in the Maven test 
command like the Browser value as explained below.

## Running the tests
The automated tests are written with the [TestNG](https://testng.org/doc/index.html) testing 
framework. TestNG has the notion of Test Suites where we can define the test cases required for the 
test suite. The sample test suite file can be found in the [testng.xml](testng.xml) file where test cases are defined.

Once your test suite is created we can now execute a maven test build via:

`mvn clean test -DtestSuite="testng.xml"`

Note: In the pom.xml file there is also a default property value for the testSuite, which will be 
used if no `-DtestSuite` is provided.

By default the tests will be executed on the Selenium node created for the Chrome browser. If you 
would like to execute the tests on the Firefox configured Selenium node, add the following system 
property argument to the Maven test command:

Firefox:
 
`mvn clean test -Dbrowser=FF`

Chrome:

`mvn clean test -Dbrowser=CH`

## Serve the Allure Report
`{path-to-allure-binary} serve allure-results`
