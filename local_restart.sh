docker-commpose down
docker-compose -f docker-compose-be.yml down
docker-compose up -d
docker-compose  -f docker-compose-be.yml up -d --build
docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' blog-app
