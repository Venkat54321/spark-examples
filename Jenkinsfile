def SEMVER
def BRANCHNAME

pipeline {

  agent {
    kubernetes {
      label 'cnapp-common-jenkins-agent'
      defaultContainer 'jnlp'
      yamlFile 'JenkinsAgentKubernetesPod.yaml'
    }
  }


  environment {
    DOCKER_REGISTRY="docker-registry.colortokens.com"
  }

  stages {
    stage('debug') {
      steps {
        container('docker-sbt') {
          sh 'sbt --version'
          sh 'java -version'
	  sh 'docker version'
        }
        container('gitversion') {
          sh 'dotnet /app/GitVersion.dll /exec'
          sh 'dotnet /app/GitVersion.dll /output buildServer'
        }
        script {
          def props = readProperties file: 'gitversion.properties'
          SEMVER = props.GitVersion_SemVer
          BRANCHNAME = props.GitVersion_BranchName
          echo "$SEMVER"
          sh 'printenv'
          sh 'ls'
        }
      }
    }


    stage('Build') {
      steps {
        container('docker-sbt') {
        script {
          withEnv(["VERSION=$SEMVER"]) {
              sh 'sbt package'
            }
          }
        }
      }
    }
   
   stage('Test') {
      steps {
        container('docker-sbt') {
        script {
          withEnv(["VERSION=$SEMVER"]) {
              sh 'sbt package'
            }
          }
        }
      }
    }

    stage('Docker Publish') {
          steps {
            container('docker-sbt') { 
            withDockerRegistry([credentialsId: 'docker-registry-credentials', url: 'https://${DOCKER_REGISTRY}']) {
             script {
                  withEnv(["VERSION=$SEMVER"]) {
                    sh 'sbt "server / docker:publish"'
                  }
               }
              }
            }
          }
    }

    stage('Git Tagging and  Push') {
      steps {
        container('docker-sbt') {
         script {
          withEnv(["VERSION=$SEMVER"]) {
          sshagent (credentials: ['ct-cnapp-noreply-bitbucket']) {
            echo ' Creating Tag - All Stages successful'
            sh 'git tag -a $VERSION -m $VERSION '
            sh 'ssh -vT -o "StrictHostKeyChecking=no" git@bitbucket.org'
            sh "git push --set-upstream origin $BRANCHNAME && git push --tags"
             }
            }
          }
        }
      }
    }
}

  post {
      always{
        script {
          def jobName = currentBuild.fullDisplayName
          def replyTo = 'ct-appsec-ana@colortokens.com'
          def recipientsTo = 'ct-appsec@colortokens.com'
          emailext body: '''${SCRIPT, template="groovy-html.template"}''',
            compressLog: true,
            mimeType: 'text/html',
            recipientProviders: [developers(), culprits(), requestor()],
            replyTo: "${replyTo}",
            subject: "[Jenkins] - ${jobName} Build Version : ${SEMVER}",
            to: "${recipientsTo}"
        }
      }
    }
}
