# Prerequisite

- `Pipeline: Basic Steps` & `view-job-filters` installed before you use this project.
- Cancel `Lightweight checkout` for your jenkins's job.
- Update jenkins security configure below.

```groovy
import jenkins.model.Jenkins
Jenkins j = Jenkins.instance

if(!j.isQuietingDown()) {
    def job_dsl_security = j.getExtensionList('javaposse.jobdsl.plugin.GlobalJobDslSecurityConfiguration')[0]
    if(job_dsl_security.useScriptSecurity) {
        job_dsl_security.useScriptSecurity = false
        println 'Job DSL script security has changed.  It is now disabled.'
        job_dsl_security.save()
        j.save()
    }
    else {
        println 'Nothing changed.  Job DSL script security already disabled.'
    }
}
else {
    println 'Shutdown mode enabled.  Configure Job DSL script security SKIPPED.'
}
```

- Troubleshooting about job dsl name issue, Ref: https://issues.jenkins-ci.org/browse/JENKINS-32011
- How to execute JobDSL Script in Jenkins Pipeline, Ref: https://stackoverflow.com/questions/41588626/invoke-job-dsl-from-jenkins-pipeline
- Ref: https://github.com/jenkinsci/job-dsl-plugin/wiki/User-Power-Moves#use-job-dsl-in-pipeline-scripts
- Ref: https://stackoverflow.com/questions/37864542/jenkins-pipeline-notserializableexception-groovy-json-internal-lazymap
