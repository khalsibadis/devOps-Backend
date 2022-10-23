
pipeline {
          agent any
          stages{
            stage('Checkout GIT'){
                steps{
                    echo 'Pulling...';
                    git branch: 'AymenBack',
                     credentialsId: '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',
                    url : 'https://github.com/khalsibadis/devOps-Backend.git';
                }

            }
            stage('MVN CLEAN'){
            steps{
                echo 'Pulling...';
                sh  'mvn clean'
                }
            }
             stage('MVN COMPILE'){
                steps{
                   sh  'mvn compile'
                }
             }
             stage('MVN PACKAGE'){
                steps{
                    sh  'mvn package'
                }
             }
             stage('DOCKER COMPOSE') {
                steps {
                   sh 'docker-compose up -d --build'
                }
             }
              stage('MVN SONARQUBE '){
                 steps{
                    sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=esprit'
                 }
              }
              stage("nexus deploy"){
                 steps{
                    sh 'mvn  deploy'
                 }
              }
          }

          }








