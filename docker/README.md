# Docker Compose for PostgreSQL 

## About
This docker container will create a folder called "config" that will store the data that is stored inside the database. 

## Configuration
```text
# database.env
POSTGRES_USER={postgres user}
POSTGRES_PASSWORD={postgres password}
POSTGRES_DB={postgres database}

# docker-compose.yml
db:
    ...
    volumes:
        - {wherever you want to save the database data}:/var/lib/postgresql/data/
    ports:
        - '{external port to access database}:5432'
adminer:
    ...
    ports: 
        - {external port for webui}:8080
```

## Usage
```bash
// assumes you already have docker engine installed

// spin up container via linux cli
$ docker-compose up -d

// spin down container via linux cli
$ docker-compose down
```