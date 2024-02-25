def buildJar() {
  echo "Building the application..."
  echo 'mvn package'
}

def buildImage() {
  echo "Building the docker image..."
  withCredentials([usernamePassword(credentialsId: 'docker-hub-id', passwordVariable: 'DOCKER_PASS', usernameVariable: 'DOCKER_USER')]) {
    echo "docker build -t $DOCKER_USER/demo-app:jma-2.0 ."
    echo "echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin"
    echo "docker push $DOCKER_USER/demo-app:jma-2.0"
  }
}
def deployApp() {
  echo "Deploying the application..."
}

return this