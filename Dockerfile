FROM centos
LABEL NourheneKheriji5SE1
RUN yum install java-11-openjdk-devel
CMD "echo hello to my Dockerfile"
EXPOSE 8089