pipelines {
    agent any


    stages {
        stage("Build with Maven") {
            steps{
                sh 'mvn clean install'
            }
        }
        stage("Build Docker Image") {
            steps{
                sh 'docker build -t siddesh051/java-jenkins .'
            }
        }
        stage("Push to Docker Hub") {
            steps{
                withCredentials([userbnamePassword(credentialsId: 'docker-hub-creds', usernameVariable:'DOCKER_USER',passwordVariable:'DOCKER_PASS')]){
                    sh ''' echo "$DOCKER_PASS" | docker login -u "DOCKER_USER" --password-stdin
                    docker push siddesh051/java-jenkins'''
                }
            }
        }
    }
}