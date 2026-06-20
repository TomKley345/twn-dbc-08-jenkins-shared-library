#!/usr/bin/env groovy

def call() {
    echo 'jenkins-shared-library: building the application'
    sh 'mvn package'
}
