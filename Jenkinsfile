pipeline {
    agent any

    stages {
        stage("GIT SOURCE") {
            steps {
                git url: "https://github.com/AdrianoPereiraSilva/poc-jenkins-pipeline.git", branch: "main"
            }
        }

        stage("DOCKER BUILD") {
                    steps {
                        script {
                            dockerapp = docker.build("pocjenkinspipeline/depeloy-with-jenkins:${env.BUILD_ID}",
                            "-f Dockerfile .")
                        }
                    }
                }
    }
}