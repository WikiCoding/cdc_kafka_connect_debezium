# Summary
This works the same way as the debezium/server. The difference is that I need to bring the debezium connector container up and then make a post request to http://localhost:8083/connectors with the body:
```json
{
  "name": "pg-source-connector",
  "config": {
    "connector.class": "io.debezium.connector.postgresql.PostgresConnector", 
    "database.hostname": "postgres", 
    "database.port": "5432", 
    "database.user": "postgres", 
    "database.password": "postgres", 
    "database.dbname" : "commerce", 
    "topic.prefix": "fulfillment", 
    "table.include.list": "public.Products" 
  }
}
```

Also we will need to add to the psql db the ```decoderbufs``` plugin alongside with the ```wal```configuration, or use image debezium/postgres:latest instead.

See:
https://github.com/debezium/postgres-decoderbufs/blob/main/README.md
https://debezium.io/documentation/reference/stable/connectors/postgresql.html#installing-postgresql-output-plugin
