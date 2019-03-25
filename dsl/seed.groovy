def jobName = 'First Job'

job(jobName) {
    description("A simple Freestyle Job")
}

pipelineJob('example') {
    definition {
        cps {
            script(readFileFromWorkspace('project-a-workflow.groovy'))
            sandbox()
        }
    }
}
