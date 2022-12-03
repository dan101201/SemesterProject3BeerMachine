SETLOCAL
set /A port=8080

docker build --pull --rm -f "Dockerfile" -t beerfrontend:latest "."

docker run -d -p %port%:80 --rm --name HttpServer frontend:latest

START http://localhost:%port%