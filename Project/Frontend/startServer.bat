docker build --pull --rm -f "Dockerfile" -t beerfrontend:latest "."

docker run -d -p 8080:80 --rm --net beer-network --name HttpServer -it frontend:latest

START http://localhost:8080