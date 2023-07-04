pipeline {
    agent any

    stages {
        stage("GIT SOURCE") {
            steps {
                git url: "https://github.com/AdrianoPereiraSilva/poc-jenkins-pipeline.git", branch: "main"
            }
        }

        stage("NATIVE TESTS") {
            steps {
                sh "./mvnw verify -Pnative"
            }
        }

        stage("MVN BUILD") {
            steps {
                sh "./mvnw clean package -Dnative -Dquarkus.native.container-build=true -Dquarkus.native.native-image-xmx=6g"
            }
        }

        stage("BUILD IMAGE") {
            steps {
                script {
                    dockerImage = docker.build("asilva2019/poc-jenkins-pipeline:${env.BUILD_ID}", " .")
                }
            }
        }

        stage('PUSH IMAGE') {
            steps {
                script{
                    withDockerRegistry(credentialsId: "dockerhub", url: "") {
                        dockerImage.push()
                    }
                }
            }
        }
    }
}