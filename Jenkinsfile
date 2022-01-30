
pipeline {
    agent {
        agent {
          docker {
             image 'maven:3.8.1-adoptopenjdk-11'
          }
        }

        stages {
            stage('Package') {
                steps {
                    sh 'mvn package'
                }
            }
        }
}