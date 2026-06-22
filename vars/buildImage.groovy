#!/usr/bin/env groovy

def call() {
    echo 'jenkins-shared-library: building the Docker Image'

    node {
        // Zeigt alle aktuellen Verzeichnisse im PATH an
        sh 'echo "Aktueller PATH ist: $PATH"'
        
        // Sucht den absoluten Pfad zur Docker-Executable
        sh 'which docker || echo "Docker wurde im PATH nicht gefunden"'
    }
}
