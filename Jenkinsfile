pipeline {
            agent any
            
            tools { 
        maven 'maven386'  
    }
            
            stages {
                stage('preamble') {
                    steps {
                    sh 'mvn -version'
                    echo 'Hola pruebas de OpenShift'
                    }
                       
                } // stage
            } // stages
        } // pipeline
