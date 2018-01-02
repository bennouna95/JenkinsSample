
pipeline {
    agent any
    tools {
        maven 'maven 3.5.2'
        jdk 'java 1.8.0_141'
    }
    stages {
        
        stage ('Build') {
            steps {
            bat 'mvn compiler:compile'
            }
        }

        stage ('Test'){
            steps {
                bat 'mvn surefire:test'
                bat 'mvn cobertura:cobertura'
            }
            post {
                success {
                    junit '**/target/*.xml' 
                }
            }
        }

        stage ('Documentation'){
            steps {
                bat 'mvn javadoc:javadoc'
                bat 'mvn site'
            }
        }

        stage ('Deployment'){
            steps {
                bat 'mvn jar:jar'
            }
        }
    }
    post {
        success {
            bat 'mvn deploy:deploy'
        }
        failure {
            mail to: joel.tankam@gmail.com, subject: 'The Pipeline failed :('
        }
    }
}