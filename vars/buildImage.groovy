#!/usr/bin/env groovy

def call() {
    echo 'jenkins-shared-library: building the Docker Image'

    node {
        // Zeigt alle aktuellen Verzeichnisse im PATH an
        sh 'echo "Aktueller PATH ist: $PATH"'
        
        // Sucht den absoluten Pfad zur Docker-Executable
        sh 'which docker || echo "Docker wurde im PATH nicht gefunden"'
    }

    node {
        withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
            sh 'echo $USER'
            sh 'docker build -t tomkley/demo-app:jma-2.1 .'
            // no need to use full path /usr/bin/docker instead of plain 'docker'
            // sh '/usr/bin/docker build -t tomkley/demo-app:jma-2.1 .'
            sh 'echo $PASS | docker login -u $USER --password-stdin'
            sh 'docker push tomkley/demo-app:jma-2.1'
        }
    }
}
