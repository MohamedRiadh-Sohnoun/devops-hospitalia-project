pipeline {
    agent none
    environment {
        DOCKERHUB_CREDENTIALS = credentials('dh_cred')
    }
    stages {
         stage('Checkout'){
            agent any
            steps{
                git branch: 'main', url: 'https://gitlab.com/mrsoh/devops-project.git'
            }
        }
        stage('Init'){
            agent any
            steps{
            sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
        }
        stage('Build Discovery Server ') {
            agent any
            when {
                changeset "/discovery-service/*.*"
                beforeAgent true
            }
            steps {
                dir('discovery-server'){
                    sh 'docker build -t $DOCKERHUB_CREDENTIALS_USR/auth-api:$BUILD_ID .'
                    sh 'docker push $DOCKERHUB_CREDENTIALS_USR/auth-api:$BUILD_ID'
                    sh 'docker rmi $DOCKERHUB_CREDENTIALS_USR/auth-api:$BUILD_ID'
                    sh 'docker logout'
                }
            }
        }
        stage('Build frontend') {
            agent any
            when {
                changeset "**/Hospitalia/*.*"
                beforeAgent true
            }
            steps {
                dir('Hospitalia'){
                    sh 'docker build -t $DOCKERHUB_CREDENTIALS_USR/frontend:$BUILD_ID .'
                    sh 'docker push $DOCKERHUB_CREDENTIALS_USR/frontend:$BUILD_ID'
                    sh 'docker rmi $DOCKERHUB_CREDENTIALS_USR/frontend$BUILD_ID'
                    sh 'docker logout'
                }
            }
        }
        stage('Build Patient Microservice') {
            agent any
            when {
                changeset "**/patient-service/*.*"
                beforeAgent true
            }
            steps {
                dir('patient-service'){
                    sh 'docker build -t $DOCKERHUB_CREDENTIALS_USR/log-message-processor:$BUILD_ID .'
                    sh 'docker push $DOCKERHUB_CREDENTIALS_USR/log-message-processor:$BUILD_ID'
                    sh 'docker rmi $DOCKERHUB_CREDENTIALS_USR/log-message-processor:$BUILD_ID'
                    sh 'docker logout'
                }
            }
        }
        stage('Build API Gateway') {
            agent any
            when {
                changeset "**/api-gateway/*.*"
                beforeAgent true
            }
            steps {
                dir('todos-api'){
                    sh 'docker build -t $DOCKERHUB_CREDENTIALS_USR/todos-api:$BUILD_ID .'
                    sh 'docker push $DOCKERHUB_CREDENTIALS_USR/todos-api:$BUILD_ID'
                    sh 'docker rmi $DOCKERHUB_CREDENTIALS_USR/todos-api:$BUILD_ID'
                    sh 'docker logout'
                }
            }
        }
        stage('Build Appointment Microservice') {
            agent any
            when {
                changeset "**/appointment-service/*.*"
                beforeAgent true
            }
            steps {
                dir('appointment-service'){
                    sh 'docker build -t $DOCKERHUB_CREDENTIALS_USR/frontend:$BUILD_ID .'
                    sh 'docker push $DOCKERHUB_CREDENTIALS_USR/users-api:$BUILD_ID'
                    sh 'docker rmi $DOCKERHUB_CREDENTIALS_USR/users-api:$BUILD_ID'
                    sh 'docker logout'
                }
            }
        }
        stage('Build Drug Microservice') {
            agent any
            when {
                changeset "**/drug-service/*.*"
                beforeAgent true
            }
            steps {
                dir('drug-service'){
                    sh 'docker build -t $DOCKERHUB_CREDENTIALS_USR/frontend:$BUILD_ID .'
                    sh 'docker push $DOCKERHUB_CREDENTIALS_USR/users-api:$BUILD_ID'
                    sh 'docker rmi $DOCKERHUB_CREDENTIALS_USR/users-api:$BUILD_ID'
                    sh 'docker logout'
                }
            }
        }
        stage('Deploy') {
            agent any
            steps {
                sh 'docker-compose build'
                sh 'docker-compose pull'
                sh 'docker-compose up -d'
            }
        }
    }
}
