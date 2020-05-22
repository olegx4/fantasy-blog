docker rm -f blog-db
docker run -d -v /home/blog:/var/lib/postgresql/data --name blog-db -e POSTGRES_DB=blog -e POSTGRES_HOST_AUTH_METHOD=trust -p 5433:5432 postgres