pipeline {
            agent any
            
            
            
     //        tools {
    // a bit ugly because there is no `@Symbol` annotation for the DockerTool
    // see the discussion about this in PR 77 and PR 52: 
    // https://github.com/jenkinsci/docker-commons-plugin/pull/77#discussion_r280910822
    // https://github.com/jenkinsci/docker-commons-plugin/pull/52
//    'org.jenkinsci.plugins.docker.commons.tools.DockerTool' '18.09'
//  }
       
        
            
            
            
            
            
         //   agent  docker { docker --version }
      
     
      
      
            
            stages {

                        stage('clonando repositorio') {
      
  
                                    
                    steps {
          
//                        docker version // DOCKER_CERT_PATH is automatically picked up by the Docker client       
                        echo 'Clonando Repositorio' 
                       sh 'docker --version'
                        echo 'maven build'        
                        sh 'mvn clean package'
                                
                      sh  'docker build -t dekra .'
                      sh 'docker container run -p 8765:8765 --name dekra --network agu-network  dekra'
                    }
                        }
                        
                        
              
                     
                        
                        
            } // stages
        } // pipeline
