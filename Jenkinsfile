pipeline {
            agent any
            
            
            
             tools {
    // a bit ugly because there is no `@Symbol` annotation for the DockerTool
    // see the discussion about this in PR 77 and PR 52: 
    // https://github.com/jenkinsci/docker-commons-plugin/pull/77#discussion_r280910822
    // https://github.com/jenkinsci/docker-commons-plugin/pull/52
    'org.jenkinsci.plugins.docker.commons.tools.DockerTool' '18.09'
  }
       //   tools {
       // docker "docker_j"

   // } 
            
        
            
            
            
            
            
  // agent  docker
      
      agent { 
        dockerfile {    // Pick up the DockerFile in root repo. And excute every command inside the container
            args '-u root:sudo'  // Run docker run commands with these args
        } 
      }
      
      
            
            stages {

                        stage('clonando repositorio') {
                                  
                                    
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
