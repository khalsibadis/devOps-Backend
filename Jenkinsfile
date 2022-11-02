pipeline {
       agent any
        stages{
            stage('Checkout GIT'){
                steps{
                    echo 'Pulling...';
                    git branch: 'nourheneBack',
                    credentialsId: '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',
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
                sh  'mvn compile'
                }
            }
            stage('MVN PACKAGE'){
                          steps{
                              sh  'mvn package'
                          }
                    }
                    stage('Build docker image'){
                                                 steps{
                                                     script{
                                                        sh 'docker build -t nourhenekheriji/springproject .'
                                                     }
                                                 }
                                             }

                                              stage('Docker login') {

                                                                                      steps {
                                                                                       sh 'echo "login Docker ...."'
                   	sh 'docker login -u nourhenekheriji -p Nourhene1234'
                                                                            }  }


          stage('Docker push') {

                           steps {
                                sh 'echo "Docker is pushing ...."'
                               	sh 'docker push nourhenekheriji/springproject'
                                  }  }




             stage('MVN SONARQUBE ')
                        {
                            steps{
                            sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=esprit'
                            }
                        }



	}
}

/*
            stage("Email Notification"){
                  success {

                        emailext body: 'Pipeline build successfully', subject: 'Pipeline build', to: 'nourhenekh20@gmail.com'
                      }
                      failure {

                        emailext body: 'Pipeline build not success', subject: 'Pipeline build', to: 'nourhenekh20@gmail.com'
                      }
            }

*/
