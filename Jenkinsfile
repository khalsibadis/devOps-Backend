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
                      sh 'mvn  deploy'
             }
         }                   

	}
}