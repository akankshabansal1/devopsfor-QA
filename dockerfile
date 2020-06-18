FROM tomcat:alpine
MAINTAINER DevopsQATEAMTraining
RUN wget -O /usr/local/tomcat/webapps/devopsforqa.jar http://10.127.130.66:8040/artifactory/akanksha.bansalDevopsTraining/codeamazon/codeamazon/0.0.1-SNAPSHOT/codeamazon-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD /usr/local/tomcat/bin/catalina.sh run
