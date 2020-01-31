
def devops_git='https://github.com/jarulvalan/devops-challange'

freeStyleJob("DevOps-Challenge")
{
    logRotator(2,5)
    parameters{
        stringParam("simple input")
    }
    label("test")
    scm
    {
        git(devops_git, "master")
    }
    
    publishers
    {
        extendedEmail
        {
            recipientList()
            defalutSubject("Job failed")
            ddefaultContent("$BUILD_URL")
            triggers
            {
                aborted
                {
                    subject("Job aborted $JOB_NAME")
                }
            }
        }
    }
}

//dummy commit
