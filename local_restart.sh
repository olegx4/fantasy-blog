#docker rm -f blog-db
#docker run -d -v /home/blog:/var/lib/postgresql/data --name blog-db -e POSTGRES_DB=blog -e POSTGRES_HOST_AUTH_METHOD=trust -p 5433:5432 postgres
docker-commpose down
docker-compose -f docker-compose-be.yml down
#docker rm f-b-db
#docker rm f-b-app
docker-compose up -d
#docker-compose -d -p f-b-db up
docker-compose  -f docker-compose-be.yml up -d
#docker-compose  -d -f docker-compose-be.yml -p f-b-app up
#docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' f-b-app
