
pipeline {
       agent any
        stages{
            stage('Checkout GIT'){
                steps{
                    checkout([$class: 'GitSCM', branches: [[name: '*/jerbiBack']], extensions: [], userRemoteConfigs: [[credentialsId: '493c8672-5669-4e56-853b-f872137ab8aa', url: 'https://github.com/khalsibadis/devOps-Backend.git']]])
                             }
                             }

            stage('MVN CLEAN')
            {
                steps{
                sh  'mvn clean'
                }
            }
            stage('MVN COMPILE')
            {
                steps{
                sh  'mvn compile'
                }
            }
            stage('MVN PACKAGE'){
                          steps{
                              sh  'mvn package'
                          }
            }
                        stage('MVN Test'){
                                              steps{
                                                  sh  'mvn test'
                                              }
                                        }
            }
        }

