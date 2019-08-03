# build project inside docker
FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
WORKDIR /tmp/
COPY pom.xml .
COPY src src
RUN mvn package

FROM payara/micro:5.192

# copying war file to deploy folder
COPY --from=MAVEN_TOOL_CHAIN /tmp/target/mojarra-ajax-error-clustered-environment.war $DEPLOY_DIR/mojarra-ajax-error-clustered-environment.war
