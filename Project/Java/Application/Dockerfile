FROM bellsoft/liberica-openjre-debian:latest
COPY target/jar/ /jar/
EXPOSE 4567
WORKDIR /jar
CMD ["java", "-jar", "BeerBackend.jar"]