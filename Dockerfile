
FROM openjdk:10
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
EXPOSE 12345
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/.s/urandom","-jar","/app.jar"]
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]