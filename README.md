Run maven project:

mvn clean package 
mvn flyway:migrate
java -cp target/simpleShop-1.0-SNAPSHOT.jar com.monzag.checkpoint4.App
