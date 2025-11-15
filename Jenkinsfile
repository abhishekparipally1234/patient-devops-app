pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "appkle/patient-devops-app"
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/abhishekparipally1234/patient-devops-app.git'
            }
        }

        stage('Build') {
            steps {
                bat '.\\mvnw.cmd clean package'
            }
        }

        stage('Run Tests') {
            steps {
                bat '.\\mvnw.cmd test'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t %DOCKER_IMAGE%:latest .'
            }
        }

        stage('Docker Push') {
            when { expression { return false } } // enable later
            steps {
                bat 'docker login -u %DOCKER_USER% -p %DOCKER_PASS%'
                bat 'docker push %DOCKER_IMAGE%:latest'
            }
        }
    }
}
