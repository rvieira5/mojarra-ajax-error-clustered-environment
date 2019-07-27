# build project inside docker
FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
WORKDIR /tmp/
COPY pom.xml .
COPY src src
RUN mvn package

FROM tomcat:8.5.32

# configuring extra jar folder
RUN sed -i '/common\.loader/ {s/$/,"${catalina.home}\/lib\/extras\/*.jar"/ }' conf/catalina.properties
RUN mkdir lib/extras
RUN curl https://repo1.maven.org/maven2/de/javakaffee/msm/memcached-session-manager/2.3.2/memcached-session-manager-2.3.2.jar --output lib/extras/memcached-session-manager-2.3.2.jar
RUN curl https://repo1.maven.org/maven2/de/javakaffee/msm/memcached-session-manager-tc8/2.3.2/memcached-session-manager-tc8-2.3.2.jar --output lib/extras/memcached-session-manager-tc8-2.3.2.jar
RUN curl https://repo1.maven.org/maven2/net/spy/spymemcached/2.12.3/spymemcached-2.12.3.jar --output lib/extras/spymemcached-2.12.3.jar

# configuring session serialization using memcached
RUN sed -i '/<\/Context>/i<Manager className="de.javakaffee.web.msm.MemcachedBackupSessionManager" memcachedNodes="sessionmanager:11211" sticky="false" sessionBackupAsync="false" lockingMode="uriPattern:/path1|/path2" requestUriIgnorePattern=".*\.(ico|png|gif|jpg|css|js)$" />' conf/context.xml

# extra configurations
COPY conf/setenv.sh bin/

# copying war file to webapp folder
COPY --from=MAVEN_TOOL_CHAIN /tmp/target/mojarra-ajax-error-clustered-environment.war webapps/

CMD ["./bin/catalina.sh", "jpda", "run"]
