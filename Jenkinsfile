pipeline {
    agent any

    stages {
        stage('Checkout GIT') {
            steps {
               echo 'Pulling..';
                git branch: 'tarek',
                url: ' https://github.com/khalsibadis/devOps-Backend';
            }
        }
       
        stage('MVN CLEAN'){
            steps{
                sh 'mvn clean'
            }
        }
        stage('MVN COMPILE'){
            steps{
                sh 'mvn compile'
            }
        }
	    
   stage('Nexus'){
         steps{
                sh 'mvn deploy'
           }
       }
}
