def gv
pipeline {
  agent any
  parameters {
    string(name: 'VERSION', defaultValue: '1.0.0', description: 'Version of the application')
    choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: 'Version to deploy the application')
    booleanParam(name: 'executeTests', defaultValue: true, description: 'Enable run tests')
  }
  tools {
    maven 'maven-3.9.6'
  }
  stages {
    stage('init') {
      steps {
        script {
          gv = load "script.groovy"
        }
      }
    }
    stage('build') {
      steps {
        script {
          gv.buildJar()
        }
      }
    }
    stage('test') {
      when {
        expression { params.executeTests == true }
      }
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
          echo "Deploying version ${params.VERSION} to production..."
        }
      }
    }
  }
}