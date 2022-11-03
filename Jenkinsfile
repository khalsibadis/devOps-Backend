
pipeline {
       agent any
        stages{
            stage('Checkout GIT'){
                steps{
                    echo 'Pulling...';
                    git branch: 'jerbiBack',
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
        }
}
