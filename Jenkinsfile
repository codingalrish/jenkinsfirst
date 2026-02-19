pipeline {
    agent any

    environment {
        APP_ENV = 'dev'
        BUILD_VERSION = '1.0-SNAPSHOT'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/username/my-maven-app.git',
                    credentialsId: 'github-creds'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                echo "Deploying JAR..."
                # Example: copy JAR to server
                scp target/my-maven-app-${BUILD_VERSION}.jar user@server:/opt/apps/
                echo "Deployment completed."
                '''
            }
        }
    }

    post {
        success {
            emailext to: 'team@example.com',
                     subject: "Maven Build Success",
                     body: "Build and deployment completed successfully in ${APP_ENV} environment."
        }
        failure {
            emailext to: 'team@example.com',
                     subject: "Maven Build Failed",
                     body: "Please check Jenkins logs."
        }
    }
}
