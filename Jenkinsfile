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
              
                sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.1.17:9000 -Dsonar.login= 6f65f95e50f06568ca3ce6f0fa4e1c00085b7032'
            }
          }
                         stage('package artifact'){
              steps{
                  sh 'mvn package'
              }
          }
                            

	}
}