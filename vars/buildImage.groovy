#!/usr/bin/env groovy

def call() {
    echo 'jenkins-shared-library: building the Docker Image'
    node {
        withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
            sh 'docker build -t tomkley/demo-app:jma-2.1 .'
            // no need to use full path /usr/bin/docker instead of plain 'docker'
            // sh '/usr/bin/docker build -t tomkley/demo-app:jma-2.1 .'
            sh 'echo $PASS | docker login -u $USER --password-stdin'
            sh 'docker push tomkley/demo-app:jma-2.1'
        }
    }
}
