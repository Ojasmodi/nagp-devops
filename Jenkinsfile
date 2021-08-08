pipeline {
    agent any
    
    environment{
        userName='ojasmodi'
        registry='ojasmodi/serviceprovider-nagp'
        mvnHome=tool name: 'Maven', type: 'maven'
        mvnCmd = "${mvnHome}/bin/mvn"
        project_id= "nagp-k8s-assignment"
        cluster_name= "devops-final-assignment"
        branchName= "master"
        zone="us-central1-c"
    }

    stages {
        // stage('code checkout') {
        //     steps {
        //         scm checkout
        //     }
        // }
        stage('code build') {
            steps {
                echo 'Code build process'
                bat "${mvnCmd} clean package"
            }
        }
        /*stage('Run unit test cases') {
            steps {
                echo 'Running unit test cases'
                bat "${mvnCmd} test"
            }
        }
        stage('SonarQube Analysis') {
            steps {
               echo 'starting sonarqube analysis'
               withSonarQubeEnv('sonarQube') {
                  bat "${mvnCmd} sonar:sonar"
               } 
            }
        }
        stage('build docker image') {
            steps {
                echo 'Creating docker image'
                bat "docker build -t i_${userName}_${branchName} --no-cache -f Dockerfile ."
            }
        }
        stage('pushing docker image') {
            steps {
                echo 'Pushing image to docker hub'
                bat "docker tag i_${userName}_${branchName} ${registry}:${BUILD_NUMBER}"
                bat "docker tag i_${userName}_${branchName} ${registry}:latest"
                withCredentials([string(credentialsId: 'dockerPwd', variable: 'dockerCred')]) {
                   bat "docker login -u ${userName} -p ${dockerCred}" 
                }
                bat "docker push ${registry}:${BUILD_NUMBER}"
                bat "docker push ${registry}:latest"
            }
        }*/
        stage('docker deployment') {
            steps {
                echo 'Deploying docker image'
                bat "docker run --name c-${userName}-${branchName} -d -p 7200:8081 ${registry}:latest"
            }
        }
        stage('k8s deployment') {
            steps {
                echo 'Deploying on kubernetes'
                bat "gcloud container clusters get-credentials ${cluster_name} --zone ${zone} --project ${project_id}"
                bat "kubectl apply -f deployment.yaml"
                bat "kubectl apply -f service.yaml"
                echo "app deployed succesfully on k8s"
            }
        }
        
    }
}
