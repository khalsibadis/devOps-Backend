import java.text.SimpleDateFormat

pipeline {
       agent any
        stages{
            stage('Checkout GIT'){
                steps{
                    echo 'Pulling...';
                    git branch: 'badisBack',
                    url : 'https://github.com/khalsibadis/devOps-Backend.git';
                    credentialsId: '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';
                             }
                             }
            stage('Date') {
                steps {
                     script{
                     def date = new Date()
                     sdf = new SimpleDateFormat("MM/dd/yyyy")
                     println(sdf.format(date))
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
                            

	}
}