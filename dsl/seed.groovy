try {
  stage 'Create SeedJobs by Project'
    projectWithJobDsl().each { app -> createProjectJobs(app) }
} catch (err) {

  throw err

} finally {
  deleteDir()
}

def createProjectJobs(app) {
  try {
    pipelineJob(${app.name}) {
      definition {
        cpsScm {
          scm {
            git(
              'https://github.com/Dkra/cra-jenkins',
              'master'
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
