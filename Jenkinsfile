
pipeline {
    agent any
    tools {
        maven 'maven 3.5.2'
        jdk 'java 1.8.0_141'
    }
    agent {label 'SampleNode'}
    stages {
        stage ('Build') {
            steps {
            bat 'mvn clean compile'
            }
        }
        stage ('Test'){
            steps {
                bat 'mvn test cobertura:cobertura'
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
                bat 'mvn javadoc:javadoc site'
            }
            post {
                success {
                    step([$class: 'JavadocArchiver', javadocDir: 'target/site/apidocs/', keepAll: false])
                }
            }
        }
        stage('SonarQube analysis') {
    withSonarQubeEnv('My SonarQube Server') {
      // requires SonarQube Scanner for Maven 3.2+
      sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
    }
        stage ('Artifacts'){
            steps {
                bat 'mvn install'
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }
    }
    post {
        success {
            bat 'mvn deploy'
        }
        failure {
            mail (to: 'a.bennouna95@gmail.com',
                    subject: "Build failed : '${env.JOB_NAME}' (${env.BUILD_NUMBER}) ",
                    body: "Check it out ${env.BUILD_URL}.");
        }
    }
}
