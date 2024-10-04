sudo apt update

sudo apt install default-jdk -y

java -version

wget https://dlcdn.apache.org/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.tar.gz


sudo tar xf apache-maven-3.9.9-bin.tar.gz -C /opt

# Set JAVA_HOME
export JAVA_HOME=/usr/lib/jvm/default-java
export PATH=$JAVA_HOME/bin:$PATH

# Set MAVEN_HOME (Maven)
export MAVEN_HOME=/opt/apache-maven-3.9.9
export M3_HOME=$MAVEN_HOME
export PATH=$MAVEN_HOME/bin:$PATH

# Display the variables for confirmation
echo "JAVA_HOME is set to: $JAVA_HOME"
echo "MAVEN_HOME is set to: $MAVEN_HOME"
echo "M3_HOME is set to: $M3_HOME"

sudo chmod +x ~/.bashrc

source ~/.bashrc

mvn -version

