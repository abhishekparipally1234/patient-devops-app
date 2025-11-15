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
                sh './mvnw clean package'
            }
        }

        stage('Run Tests') {
            steps {
                sh './mvnw test'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE:latest .'
            }
        }

        stage('Docker Push') {
            when { expression { return false } } // enable if you want push
            steps {
                sh 'docker login -u $DOCKER_USER -p $DOCKER_PASS'
                sh 'docker push $DOCKER_IMAGE:latest'
            }
        }
    }
}
