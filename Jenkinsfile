
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
                stage('MVN SONARQUBE ')
                                            {
                                                steps{
                                                sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=aymen123+'
                                                }
                                            }
                /**stage("nexus deploy"){
                                                           steps{
                                                                   sh 'mvn  deploy'
                                                           }
                                                      }**/
               stage('Build docker image'){
                                                 steps{
                                                     script{
                                                        sh 'docker build -t aymenjerbi/backproject .'
                                                     }
                                                 }
                                             }

                                              stage('Docker login') {

                                                                                      steps {
                                                                                       sh 'echo "login Docker ...."'
                                                                	sh 'docker login -u aymenjerbi -p Aymen123+'
                                                                            }  }
                stage('Docker push') {

                           steps {
                                sh 'echo "Docker is pushing ...."'
                               	sh 'docker push aymenjerbi/backproject'
                                  }  }
            }
        }

