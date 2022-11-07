pipeline{
    agent any
    tools {
        maven 'M2_HOME'
    }
    stages {
        stage('Getting project from Git') {
            steps{
checkout([$class: 'GitSCM', branches: [[name: '*/dali_back']], extensions: [], userRemoteConfigs: [[credentialsId: 'github', url: 'https://github.com/khalsibadis/devOps-Backend.git']]])            }
        }
        
        
        stage('Cleaning the project') {
            steps{
                sh "mvn -B -DskipTests clean  " 
            }
        }
        
        
        stage('Unit Tests') {
            steps{
                sh "mvn test " 
            }
        }
        
        
        
        stage('Artifact Construction') {
            steps{
                sh "mvn -B -DskipTests package " 
            }
        }
        
        
        stage('Code Quality Check via SonarQube') {
            steps{
                
             sh " mvn sonar:sonar -Dsonar.projectKey=dali -Dsonar.host.url=http://127.0.0.1:9000 -Dsonar.login=7f49dfa9a7de4a6435be224995687935cd5c36a8"
 
            }
        }
        
             stage('Publish to Nexus') {
            steps {
                script {
                    
configFileProvider([configFile(fileId: 'setting', variable: 'dalioues')]) {
  sh 'mvn  -B -DskipTests deploy -s $dalioues'}
                
                }
            }
        }
        
         stage('Build Docker Image') {
                      steps {
                          script {
                            sh 'docker build -t dalioueslati/spring-app .'
                          }
                      }
                  }
                  
                  
                  
                  
                  stage('Push Docker Image') {
                      steps {
                          script {
                          withCredentials([usernameColonPassword(credentialsId: 'dockerhub', variable: 'dali')]) {
                              sh 'docker login -u dalioueslati -p Dali123456@ '
                           }
                           sh 'docker push dalioueslati/spring-app'
                          }
                      }
                  }
        
        
        stage('Run Spring && MySQL Containers') {
                      steps {
                          script {
                            sh 'docker-compose up -d'
                          }
                      }
                  }
            
        
        
    }
    post{
        always {
    
    cleanWs()
 }}}
