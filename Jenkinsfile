pipeline {
    environment {
        ORG_NAME = "lenz90"
        APP_NAME = "intercorp-clientes"
        APP_CONTEXT_ROOT = "/"
        APP_LISTENING_PORT = "8080"
        TEST_CONTAINER_NAME = "ci-${APP_NAME}-${BUILD_NUMBER}"
        DOCKER_HUB = credentials("${ORG_NAME}-docker-hub")
    }
    agent any
    stages {
        stage('Compilando') {
            steps {
                echo "-=- Compilando -=-"
                sh 'chmod 777 ./*'
                sh "./mvnw clean compile"
            }
        }

        stage('Pruebas Unitarias') {
            steps {
                echo "-=- Pruebas Unitarias -=-"
                sh "./mvnw test"
            }
        }
        stage('Empaquetando Jar') {
            steps {
                echo "-=- Empaquetando Jar -=-"
                sh "./mvnw package -DskipTests"
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
        stage('Construyendo Imagen Docker') {
            steps {
                echo "-=- Construyendo Imagen Docker -=-"
                sh "docker build -t lenz90/docker-intercorp ."
            }
        }
        stage('Run Docker image') {
            steps {
                echo "-=- run Docker image -=-"
                sh "docker run -d -p 80:8080 lenz90/docker-intercorp"
                //sh "docker run --name ${TEST_CONTAINER_NAME} --detach --rm --network ci --expose 6300 --env JAVA_OPTS='-javaagent:/jacocoagent.jar=output=tcpserver,address=*,port=6300' ${ORG_NAME}/${APP_NAME}:latest"
            }
        }

    }
}