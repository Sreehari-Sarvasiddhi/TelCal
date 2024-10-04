sudo apt update

sudo apt install default-jdk -y

java -version

wget https://dlcdn.apache.org/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.tar.gz


sudo tar xf apache-maven-3.9.9-bin.tar.gz -C /opt


echo 'export JAVA_HOME=/usr/lib/jvm/default-java' >> ~/etc/profile.d/maven.sh
echo 'export M3_HOME=/opt/apache-maven-3.9.9' >> ~/etc/profile.d/maven.sh
echo 'export MAVEN_HOME=/opt/apache-maven-3.9.9' >> ~/etc/profile.d/maven.sh
echo 'export PATH=${M3_HOME}/bin:${PATH}' >> ~/etc/profile.d/maven.sh


sudo chmod +x /etc/profile.d/maven.sh

source /etc/profile.d/maven.sh

mvn -version

