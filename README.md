### Uk Postal Codes Assignment

#### How to build
- `mvn clean install`

#### How to run
- `java -jar ./location_of_jar.jar`

#### Demo
- `http://localhost:8080/distance?postalcode1=AB10 1XG&postalcode2=AB10 6RN`
- `http://localhost:8080/distance`
- `http://localhost:8080/distance?postalcode1=AB10 1XG&postalcode2=A`

#### Things to consider
- Spring Boot was used.
- Logs will be written to file at `./application.log`.
- Database is H2 db. You can view the content at `http:localhost:8080/h2-console` username: `sa` & no password.
- I didn't test with the entire `ukpostcodesmysql.sql` file, but with only 9 records.
- Choices.txt contains some information about the decisions I made.
