docker rm -f fantasy-blog-db
docker run -d -v /home/fantasy-blog:/var/lib/postgresql/data --name fantasy-blog-db -e POSTGRES_DB=fantasy-blog -p 5432:5432 postgres