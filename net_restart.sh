docker pull olegx4/f-b-app
docker pull postgres
docker stop blogdb
docker stop f-b-app
docker rm blogdb
docker rm f-b-app
docker run -d --name blogdb --network fantasyblog_blog-db-network -v "/blogdb:/var/lib/postgresql/data" -e POSTGRES_DB=blog -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -p 5432:5432 postgres
docker run -d --name f-b-app --network fantasyblog_blog-db-network -e DB_HOST=blogdb -e DB_PORT=5432  -p 8000:8080 --name f-b-app olegx4/f-b-app
docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' f-b-app