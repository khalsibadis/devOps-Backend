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
                sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.1.17:8080/ -Dsonar.login=esprit'
            }
          }
                         stage('package artifact'){
              steps{
                  sh 'mvn package'
              }
          }
                            

	}
}