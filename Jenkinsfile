
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

              stage('MVN SONARQUBE '){
                 steps{
                    sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=esprit'
                 }
              }
              stage("nexus deploy"){
                 steps{
                  //  sh 'mvn deploy'
                  nexusArtifactUploader artifacts: [[artifactId: 'tpAchatProject', classifier: '', file: 'target/tpAchatProject-1.0.4.jar', type: 'jar']], credentialsId: 'nexus-snapshots', groupId: 'com.esprit.examen', nexusUrl: '192.168.33.166:8081', nexusVersion: 'nexus2', protocol: 'http', repository: 'http://192.168.33.166:8081/repository/nexus-snapshots/', version: '1.0.4'
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








