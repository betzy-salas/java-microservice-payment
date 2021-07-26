echo **************************************************************
echo Generate JAR
echo **************************************************************
mvn clean package -DskipTests
echo **************************************************************
echo BUILD AND PUSH Docker
echo **************************************************************
docker stop ms_payment
docker rm  ms_payment
echo **************************************************************
docker  build -t betzysalasvergara/ms_payment_v1 .
docker push  betzysalasvergara/ms_payment_v1
echo **************************************************************
echo run image 
docker run -p 8080:8080 --name ms_payment_v1 --network afor256 -d betzysalasvergara/ms_paymente_v1
echo *************************************************************
echo End Process
echo *************************************************************