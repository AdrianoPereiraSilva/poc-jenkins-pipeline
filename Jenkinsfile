pipeline {
    agent any

    stages {
        stage("GIT SOURCE") {
            steps {
                git url: "https://github.com/AdrianoPereiraSilva/poc-jenkins-pipeline.git", branch: "main"
            }
        }

        stage("MVN BUILD") {
            steps {
                sh "./mvnw clean package -Dnative -Dquarkus.native.container-build=true -Dquarkus.native.native-image-xmx=6g"
            }
        }
    }
}