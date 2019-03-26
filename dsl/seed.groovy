def jobName = 'Freestyle Job'

job(jobName) {
  description('A simple Freestyle Job')
}

pipelineJob('cra-jenkins-project') {
  definition {
    cpsScm {
      scm {
        git(
          'https://github.com/Dkra/cra-jenkins',
          'master')
      }
      scriptPath('Jenkinsfile') // Defualt: Jenkinsfile
    }
  }
}
