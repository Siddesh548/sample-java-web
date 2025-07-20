pipeline {
    agent any

    environment {
    DOCKER_IMAGE = "siddesh051/java-jenkins"
    CONTAINER_NAME = "java-webapp-jenkins"
    EC2_IP = "3.82.192.8"         // <-- Replace with your EC2 public IP
    EC2_USER = "ubuntu"              // <-- Replace with 'ec2-user' or 'ubuntu' depending on your AMI
    }


    stages {
        
        stage("Build Docker Image") {
            steps{
                sh 'docker build -t siddesh051/java-jenkins .'
            }
        }

        stage("Push to Docker Hub") {
            steps{
                withCredentials([usernamePassword(credentialsId: 'docker-hub-creds', usernameVariable:'DOCKER_USER',passwordVariable:'DOCKER_PASS')]){
                    sh ''' echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                    docker push siddesh051/java-jenkins'''
                }
            }
        }
        stage('Deploy to EC2') {
            steps {
                sshagent(['ec2-ssh-key']) {
                    sh '''
                        ssh -o StrictHostKeyChecking=no $EC2_USER@$EC2_IP "
                            docker pull $DOCKER_IMAGE
                            docker run -d -p 8081:8081 --name $CONTAINER_NAME $DOCKER_IMAGE
                        "
                    '''
                }
            }
        }
    }
}