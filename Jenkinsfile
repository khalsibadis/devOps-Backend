pipeline {
       agent any
        stages{
            stage('Checkout GIT'){
                steps{
                    echo 'Pulling...';
                    git branch: 'tarek',
                    url : 'https://github.com/khalsibadis/devOps-Backend.git';
                             }
                             }

           /* stage('MVN CLEAN')
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
                           stage('MVN Test'){
                                              steps{
                                                  sh  'mvn test'
                                              
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
                 stage('Build docker image'){
                         steps{
                                sh 'docker build -t tarekabdennadherr/spring .'

                                      }
                                         }
*/
                                              stage('Docker login') {

                                                         steps {
                                                            sh 'echo "login Docker ...."'
                                                                	sh 'docker login -u tarekkkk -p tarek12345'
                                                                            }  }


          stage('Docker push') {

                           steps {
                                sh 'echo "Docker is pushing ...."'
                               	sh 'docker push tarekkkk/spring'
                                  }  }



	}

}
