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
            
            stage('MVN CLEAN')
            {
                steps{
                sh  'mvn clean'
                }
            }
            stage('MCN COMPILE')
            {
                steps{
                sh  'mvn compile'
                }
            }
           
                         stage("nexus deploy"){
                                       steps{
                                               sh 'mvn  deploy'
                                       }
                                  }
	}
}
