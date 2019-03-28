pipeline {
  agent any

  environment {
    REPO = "https://github.com/Dkra/jenkins-job-dsl-example.git"
    REPO_BRANCH = "master"
  }

  parameters {

  }

  stages {
    stage('Clone Seed Job Project') {
      steps {
        echo 'Before Building Jobs-------'
        deleteDir()
        checkout(
          changelog: true,
          poll: true,
          scm: [
              $class: 'GitSCM',
              branches: [[name: env.REPO_BRANCH]],
              doGenerateSubmoduleConfigurations: false,
              submoduleCfg: [],
              userRemoteConfigs: [[name: 'origin', url: env.REPO_URL]]
          ]
        )
        ls
      }
    }

    stage('Building Jobs by Project') {
      steps {
        echo '------Building Jobs-------'
      }

      steps {
        ls
        // projectWithJobDsl().each { app -> createProjectJobs(app) }
      }
    }

    stage('After Building Jobs') {
      steps {
        echo 'After Building Jobs-------'
      }
    }
  }

  post {
    always {

    }

    failure {

    }

    success {

    }

    cleanup {

    }
  }
}

def createProjectJobs(app) {
  try {
    pipelineJob('${app.name}') {
      definition {
        cpsScm {
          scm {
            git(
              '${app.url}',
              '${app.branch}'
            )
          }
          scriptPath('Jenkinsfile') // Defualt: Jenkinsfile
        }
      }
    }
  } catch (err) {
    throw err
  }
}





def projectWithJobDsl() {
  return [
    [
      name: 'cra-jenkins-1',
      repo_url: 'https://github.com/Dkra/cra-jenkins',
      branch: 'master'
    ],
    [
      name: 'cra-jenkins-2',
      repo_url: 'https://github.com/Dkra/cra-jenkins',
      branch: 'master'
    ]
  ]
}
