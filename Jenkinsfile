pipeline {
            agent any
           
            
 //  agent { dockerfile true }
            
            stages {
                        
                        stage('clonando repositorio') {
                                    agent {
                docker { image 'maven:3.9.0-eclipse-temurin-11' }
            }
                                    
                                    
                    steps {
                        echo 'Clonando Repositorio' 
                        sh 'docker container ls'
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
