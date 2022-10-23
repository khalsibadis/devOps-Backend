
pipeline {
          agent any
          stages{
            stage('Checkout GIT'){
                steps{
                    echo 'Pulling...';
                    git branch: 'AymenBack',
                    url : 'https://github.com/khalsibadis/devOps-Backend.git';
                }

            }
            stage('MVN CLEAN'){
            steps{
                echo 'Pulling...';
                sh 'mvn clean'
                }
            }
             stage('MVN COMPILE'){
                steps{
                sh 'mvn compile'
                }
             }
             stage('MVN PACKAGE'){
                steps{
                sh 'mvn package'
                }
             }
           /*  stage('DOCKER COMPOSE') {
                steps {
                   sh 'docker-compose up -d --build'
                }
             }*/
              stage('MVN SONARQUBE '){
                 steps{
                    sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=esprit'
                 }
              }
              stage("nexus deploy"){
                 steps{
                    sh 'mvn  deploy'
                 }
              }
          }
              post {
                      success {
                          mail bcc: '', body: 'Pipeline build successfully', cc: '', from: 'jbara.aymen@esprit.tn', replyTo: '', subject: 'The Pipeline success', to: 'aymen.jb.06@gmail.com'
                      }
                      failure {
                          mail bcc: '', body: 'Pipeline build not success', cc: '', from: 'jbara.aymen@esprit.tn', replyTo: '', subject: 'The Pipeline failed', to: 'aymen.jb.06@gmail.com'
                       }
                  }

          }








