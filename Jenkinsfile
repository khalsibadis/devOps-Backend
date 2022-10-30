pipeline {
       agent any
        stages{
            stage('Checkout GIT'){
                steps{
                    echo 'Pulling...';
                    git branch: 'nourheneBack',
                    url : 'https://github.com/khalsibadis/devOps-Backend.git';
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
                sh  'mvn compile -e'
                }
            }
      
        stage("build & SonarQube analysis") {
            steps {

               sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=esprit'
               
            }
          }
         stage('package artifact'){
              steps{
                  sh 'mvn package'
              }
          }

          stage("nexus deploy"){
            steps{
                nexusArtifactUploader artifacts: [
                    [
            artifactId: 'tpAchatProject',
               classifier: '',
         file: '/var/lib/jenkins/workspace/projetDevops/target/docker-spring-boot.jar',
            type: 'jar'
        ]
     ],
            credentialsId: 'nexus-snapshots',
           groupId: 'com.esprit.examen',
        nexusUrl: '192.168.1.17:8081',
      nexusVersion: 'nexus3',
   protocol: 'http', 
   repository: 'Devops-Back-Release', 
   version: '2.2.2'
              }
          }
            stage ('Build'){
             steps{
                sh 'docker build -t nourhenekheriji/openjdk:latest .'
             }
            }
     stage('Login'){
       steps{
         sh 'echo "login Docker ...."'
         sh 'docker login -u nourhenekheriji -p Nourhene1234'

       }
     }
  stage ('Push'){
    steps{
      sh 'docker push nourhenekheriji/openjdk:latest'
    }
   }
 post {
   always{
     sh 'docker logout'
    }
   }



            stage("Email Notification"){
                  success {
                       
                        emailext body: 'Pipeline build successfully', subject: 'Pipeline build', to: 'nourhenekh20@gmail.com'
                      }
                      failure {
                
                        emailext body: 'Pipeline build not success', subject: 'Pipeline build', to: 'nourhenekh20@gmail.com'
                      }
            }


	}
}