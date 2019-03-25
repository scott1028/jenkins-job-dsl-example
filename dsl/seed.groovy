def jobName = 'Freestyle Job'

job(jobName) {
  description('A simple Freestyle Job')
}

pipelineJob('PipelineJob example') {
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
