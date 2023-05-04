pipeline {
            agent any
            
    
            
            stages {
                        
                        stage('clonando repositorio') {
                    steps {
                        echo 'Clonando Repositorio'        
                    }
                        }
                        
                        
                stage('maven deploy') {
                    steps {
 
sh 'mkdir -p /usr/share/maven /usr/share/maven/ref \
  && echo "Downlaoding maven" \
  && curl -fsSL -o /tmp/apache-maven.tar.gz https://apache.osuosl.org/maven/maven-3/3.8.8/binaries/apache-maven-3.8.8-bin.tar.gz \
  \
  && echo "Checking download hash" \
  && echo "332088670d14fa9ff346e6858ca0acca304666596fec86eea89253bd496d3c90deae2be5091be199f48e09d46cec817c6419d5161fb4ee37871503f472765d00  /tmp/apache-maven.tar.gz" | sha512sum -c - \
  \
  && echo "Unziping maven" \
  && tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
  \
  && echo "Cleaning and setting links" \
  && rm -f /tmp/apache-maven.tar.gz'
  //&& ln -s /usr/share/maven/bin/mvn /usr/bin/mvn'

//ENV MAVEN_HOME /usr/share/maven
//ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"


                    
                    }
                       
                } // stage
                        
                        
                            stage('maven build') {
                    steps {
                        sh 'mvn -version'
                    echo 'Hola pruebas de OpenShift'
                    sh 'mvn package'       
                    }
                        }
                        
                        
                        
            } // stages
        } // pipeline
