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
                  sh 'mvn deploy:deploy-file -DgroupId=com.esprit.examen
                        -DartifactId=tpAchatProject
                        -Dversion=1.0
                        -Dpackaging=jar
                        -Dfile=./target/tpAchatProject-1.0.jar
                        -DrepositoryId=Devops-Back-Release
                        -Durl=http://192.168.1.17:8081/repository/Devops-Back-Release/'
              }
          }

	}
}