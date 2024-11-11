# Summary
The main scope of this project is to experiment to use a MySQL Database with Prisma ORM

## Dependencies
1. ```npm install prisma```
2. ```npm install @prisma/client```

## Usage
1. ```npx prisma init``` and this will create a prisma directory with schema.prisma inside and a .env file in the root of the project
2. in schema.prisma connect to the database:
```javascript
datasource db {
    provider = "mysql"
    url      = env("DATABASE_URL")
}
```
3. DATABASE_URL is set in the .env file. ```DATABASE_URL="mysql://root:mysql@localhost:5306/commerce?schema=public"```
4. Define a schema:
```
model Product {
  id              Int       @id @default(autoincrement())
  product_name    String    @db.VarChar(255)
}
```

5. run the migrations, which creates the migration directory and updates the database with the migrations:
```bash
npx prisma migrate dev --name init
```