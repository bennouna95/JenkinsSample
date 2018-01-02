
pipeline {
    agent any
    tools {
        maven 'maven 3.5.2'
        jdk 'java 1.8.0_141'
    }
    stages {
        
        stage ('Build') {
            steps {
            bat 'mvn clean compiler:compile'
            }
        }

        stage ('Test'){
            steps {
                bat 'mvn surefire:test cobertura:cobertura'
            }
            post {
                success {
                    junit '**/target/surefire-reports/*.xml'
                    step([$class: 'CoberturaPublisher', autoUpdateHealth: false, autoUpdateStability: false, coberturaReportFile: '**/target/site/cobertura/coverage.xml', failUnhealthy: false, failUnstable: false, maxNumberOfBuilds: 0, onlyStable: false, sourceEncoding: 'ASCII', zoomCoverageChart: false])

                }
            }
        }

        stage ('Documentation'){
            steps {
                bat 'mvn javadoc:javadoc site:site'
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
            mail (to: "joel.tankam@gmail.com",
                    subject: "Build failed : JenkinsPipeline",
                    body: "Check it out.");
        }
    }
}