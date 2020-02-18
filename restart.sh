docker rm -f fantasy-blog-db
docker run -d -v /home/fantasy-blog:/var/lib/postgresql/data --name fantasy-blog-db -e POSTGRES_DB=fantasy-blog -e POSTGRES_HOST_AUTH_METHOD=trust -p 5432:5432 postgres