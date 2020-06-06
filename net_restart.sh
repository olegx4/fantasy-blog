docker-compose down
docker pull olegx4/f-b-app:0.0.1
docker stop f-b-app
docker rm f-b-app
docker-compose up -d
docker run -d --name f-b-app --network fantasyblog_blog-db-network -e DB_HOST=blogdb -e DB_PORT=5432  -p 8000:8080 --name f-b-app olegx4/f-b-app:0.0.1
docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' f-b-app