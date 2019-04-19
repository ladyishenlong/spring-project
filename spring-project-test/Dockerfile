FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
EXPOSE 10001
ENTRYPOINT ["java","-jar","/app.jar"]

#在运行之前，需要先对工程进行打包
#docker ps 查看端口号 根据暴露的端口号进行访问