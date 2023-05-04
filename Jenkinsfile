pipeline {
            agent any
            
    
            
            stages {
                stage('preamble') {
                    steps {
                                
  sh 'sudo -i'

sh' mkdir -p /usr/share/maven /usr/share/maven/ref \
  && echo "Downlaoding maven" \
  && curl -fsSL -o /tmp/apache-maven.tar.gz https://apache.osuosl.org/maven/maven-3/3.8.8/binaries/apache-maven-3.8.8-bin.tar.gz \
  \
  && echo "Checking download hash" \
  && echo "${SHA}  /tmp/apache-maven.tar.gz" | sha512sum -c - \
  \
  && echo "Unziping maven" \
  && tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
  \
  && echo "Cleaning and setting links" \
  && rm -f /tmp/apache-maven.tar.gz \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn'

//ENV MAVEN_HOME /usr/share/maven
//ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"


                    sh 'mvn -version'
                    echo 'Hola pruebas de OpenShift'
                    }
                       
                } // stage
            } // stages
        } // pipeline
