import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.SvnVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2019.2"

project {

    vcsRoot(HttpUnit1413LabsIntelliJNetSvnKot1)

    buildType(BuildOne)
}

object BuildOne : BuildType({
    name = "build one"

    vcs {
        root(HttpUnit1413LabsIntelliJNetSvnKot1)
    }

    steps {
        script {
            scriptContent = "echo test"
        }
    }
})

object HttpUnit1413LabsIntelliJNetSvnKot1 : SvnVcsRoot({
    name = "http://UNIT-1413.Labs.IntelliJ.Net/svn/kot1/"
    url = "http://UNIT-1413.Labs.IntelliJ.Net/svn/kot1/"
    userName = "admin"
    password = "credentialsJSON:4102d9f6-9824-4159-9085-a8a1820b28fb"
})
