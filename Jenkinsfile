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

        stage("DOCKER BUILD") {
            steps {
                script {
                    dockerapp = docker.build("apesilva2019/deploy-with-jenkins:${env.BUILD_ID}",
                    " .")
                }
            }
        }
    }
}