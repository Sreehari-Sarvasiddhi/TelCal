sudo apt update

sudo apt install default-jdk -y

java -version

sudo apt install maven

mvn -version

mvn clean install

cd target

nohup java -jar TelCal-0.0.1-SNAPSHOT.jar&

