docker build --pull --rm -f "Dockerfile" -t frontend:latest "."

docker run -P --rm frontend:latest

