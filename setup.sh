sudo apt update

sudo apt install default-jdk -y

java -version

wget https://dlcdn.apache.org/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.tar.gz


sudo tar xf apache-maven-3.9.9-bin.tar.gz -C /opt

# Set JAVA_HOME
export PATH=/usr/lib/jvm/default-java/bin:$PATH

# Set MAVEN_HOME (Maven)
export PATH=/opt/apache-maven-3.9.9/bin:$PATH

# Display the variables for confirmation
echo "PATH is set to: $PATH"

sudo chmod +x ~/.bashrc

source ~/.bashrc

mvn -version

