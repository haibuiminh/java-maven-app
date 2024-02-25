
pipeline {
  agent any
  environment {
    NEW_VERSION = '1.3.0'
    GITHUB_CREDENTIALS = credentials('github-credential')
  }
  stages {
    stage('build') {
      steps {
        script {
          echo "Building the application..."
          echo "building version ${NEW_VERSION}"
        }
      }
    }
    stage('test') {
      steps {
        script {
          echo "Testing the application..."
          withCredentials([usernamePassword(credentialsId: 'github-credential', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
            echo "Username: ${USERNAME}"
            echo "Password: ${PASSWORD}"
          }
        }
      }
    }
    stage('deploy') {
      steps {
        script {
          echo "Deploying the application..."
          echo "deploying with credentials ${GITHUB_CREDENTIALS}"
          sh "${GITHUB_CREDENTIALS}"
        }
      }
    }
  }
}