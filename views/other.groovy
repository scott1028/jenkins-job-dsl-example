listView('Other') {
    description('For uncategory jobs')
    
    filterBuildQueue()
    filterExecutors()

    jobs {
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
