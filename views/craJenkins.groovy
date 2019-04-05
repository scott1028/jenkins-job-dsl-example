listView('cra-jenkins-Project') {
    description('All cra-jenkins related Projects')
    filterBuildQueue()
    filterExecutors()
    jobs {
        // add jobs matched by this rule
        regex(/cra-jenkins.+/)
    }
    jobFilters {
        status {
            status(Status.UNSTABLE)
        }
    }
    columns {
        status()
        weather()
        name()
        lastSuccess()
        lastFailure()
        lastDuration()
        buildButton()
    }
}
