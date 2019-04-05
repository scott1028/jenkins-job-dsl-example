import groovy.json.JsonSlurperClassic

node {
  // For workspace of pipeline
  stage("Clean legacy data") {
    sh """
      rm -rf .git
      rm -rf *.*
      rm -rf *
    """
  }

  stage('Build ListView') {
    dir("../${JOB_NAME}@script") {
      jobDsl ignoreMissingFiles: true, targets: './views/*.groovy'
    }
  }

  stage('Build SeedJob by projects') {
    dir("../${JOB_NAME}@script") {
      def json = readFile(file: "./jobs/default.json")
      def jobArray = new JsonSlurperClassic().parseText(json)
      jobArray.each { item -> createProjectJobs(item) }
    }
  }
}

def createProjectJobs(item) {
  stage("Build ${item.name} Seed Job") {
    dir("../${JOB_NAME}@script/${item.name}") {
      git branch: "${item.branch}", url: "${item.repo_url}"
      jobDsl ignoreMissingFiles: true, targets: './jenkins/**/seed.groovy'
    }
  }
}
