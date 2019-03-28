node {
    try {
        stage "build by projects"
            projectWithJobDsl().each { app -> createProjectJobs(app) }
    } catch (err) {
        throw err
    } finally {

    }
}


def createProjectJobs(app) {
    sh """
        echo "${app.name}"
    """
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
