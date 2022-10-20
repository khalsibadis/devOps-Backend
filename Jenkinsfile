import java.text.SimpleDateFormat

pipeline {
       agent any
        stages{
            stage('Checkout GIT'){
                steps{
                    echo 'Pulling...';
                    git branch: 'badisBack',
                    credentialsId: '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',
                    url : 'https://github.com/khalsibadis/devOps-Backend.git';
                             }
                             }
   stage('Testing process') {
                              steps {
                               script {
                                sh 'echo "Test is processing ...."'
                                sh 'mvn test'
                               }

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

             stage('MVN SONARQUBE ')
                        {
                            steps{
                            sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
                            }
                        }
                        stage("nexus deploy"){
                                       steps{
                                               sh 'mvn  deploy'
                                       }
                                  }
                            

	}
}