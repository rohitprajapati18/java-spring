pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Deploy') {
            steps {
                sh 'sudo mvn spring-boot:run'
            }
        }
    }
}
