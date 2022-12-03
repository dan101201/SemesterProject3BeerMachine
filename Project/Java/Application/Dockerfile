FROM bellsoft/liberica-openjre-debian:latest

COPY target/jar/ /jar/
WORKDIR /jar

CMD ["java", "-jar", "BeerBackend.jar"]

EXPOSE 4567