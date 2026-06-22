#!/usr/bin/env groovy

def call() {
    echo 'jenkins-shared-library: building the Docker Image'

    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh 'docker build -t tomkley/demo-app:jma-2.3 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push tomkley/demo-app:jma-2.3'
    }
}
