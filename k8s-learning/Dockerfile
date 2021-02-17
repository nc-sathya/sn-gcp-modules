FROM java:8
EXPOSE 8080
ADD /target/k8s-learning-0.0.1-SNAPSHOT.jar k8s-learning.jar
ENTRYPOINT ["java", "-jar", "k8s-learning.jar"]