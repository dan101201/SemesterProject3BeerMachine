docker build --pull --rm -f "Dockerfile" -t beerfrontend:latest "."

docker run -d -p 8080:80 --ip 172.18.0.123 --net beer-network --name BeerFrontend -it beerfrontend:latest

START http://localhost:8080