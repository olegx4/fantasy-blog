**How to use fantasy-blog app:**

Pull docker images from docker.hub:

`docker pull olegx4/f-b-app`

`docker pull postgres`

Create a network for using images:

`docker network create fantasyblog_blog-db-network`

Run images (**db** and **app**) with following parameters:

`docker run -d --name blogdb --network fantasyblog_blog-db-network -v "/blogdb:/var/lib/postgresql/data" -e POSTGRES_DB=blog -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -p 5432:5432 postgres`

`docker run -d --name f-b-app --network fantasyblog_blog-db-network -e DB_HOST=blogdb -e DB_PORT=5432  -p 8000:8080 --name f-b-app olegx4/f-b-app`

Or you can simply run `net_restart.sh` in terminal (linux).
App cannot work without db image.
