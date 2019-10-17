pipeline {
    agent {
        docker {
            image 'adoptopenjdk/openjdk11:jdk-11.0.3_7'
            args '--network ci --mount type=volume,source=ci-maven-home,target=/root/.m2'
        }
    }

    environment {
        ORG_NAME = "lenz90"
        APP_NAME = "intercorp-clientes"
        APP_CONTEXT_ROOT = "/"
        APP_LISTENING_PORT = "8080"
        TEST_CONTAINER_NAME = "ci-${APP_NAME}-${BUILD_NUMBER}"
        DOCKER_HUB = credentials("${ORG_NAME}-docker-hub")
    }

    stages {
        stage('Compile') {
            steps {
                echo "-=- compiling project -=-"
                sh "./mvnw clean compile"
            }
        }

        stage('Unit tests') {
            steps {
                echo "-=- execute unit tests -=-"
                sh "./mvnw test"
            }
        }
    }
}
