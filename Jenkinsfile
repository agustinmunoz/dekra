pipeline {
            agent any
            
            
            
             tools {
    // a bit ugly because there is no `@Symbol` annotation for the DockerTool
    // see the discussion about this in PR 77 and PR 52: 
    // https://github.com/jenkinsci/docker-commons-plugin/pull/77#discussion_r280910822
    // https://github.com/jenkinsci/docker-commons-plugin/pull/52
    'org.jenkinsci.plugins.docker.commons.tools.DockerTool' '18.09'
  }
       
        
            
            
            
            
            
         //   agent  docker { docker --version }
      
     
      
      
            
            stages {

                        stage('clonando repositorio') {
      
  agent {
        docker {
            image "bash:latest"
            args '--network agu-network'
        }
    }
                                    
                    steps {
          
                                
                        echo 'Clonando Repositorio' 
                       // docker --version
                    }
                        }
                        
                        
              
                        
                            stage('maven build') {
                    steps {
                        sh 'mvn -version'
                    echo 'Hola pruebas de OpenShift'
                    sh 'mvn package'       
                    }
                        }
                        
                        
                        
            } // stages
        } // pipeline
