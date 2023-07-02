plugins {
    base
    id("org.gradle.wrapper-upgrade") version "0.11.2"
}

val gradleRepos = listOf(
    "junit-team/junit5",
    "junit-team/testng-engine",
    "junit-team/wrapper-upgrade",
    "ota4j-team/open-test-reporting",
    "ota4j-team/opentest4j",
)

val gradleSampleProjects = listOf(
    "junit5-jupiter-extensions",
    "junit5-jupiter-starter-gradle",
    "junit5-jupiter-starter-gradle-groovy",
    "junit5-jupiter-starter-gradle-kotlin",
    "junit5-migration-gradle",
    "junit5-multiple-engines",
)

val mavenSampleProjects = listOf(
    "junit5-jupiter-starter-maven",
    "junit5-jupiter-starter-maven-kotlin",
    "junit5-migration-maven",
)

val gitCommitArgs = listOf(
    "--author=JUnit Team <team@junit.org>",
    "--no-gpg-sign",
)

wrapperUpgrade {
    gradle {
        gradleRepos.forEach { repoName ->
            create(repoName.replace('/', '-')) {
                repo.set(repoName)
            }
        }
        gradleSampleProjects.forEach { projectName ->
            create("${projectName}-sample") {
                repo.set("junit-team/junit5-samples")
                dir.set(projectName)
            }
        }
        configureEach {
            options.gitCommitExtraArgs.set(gitCommitArgs)
        }
    }
    maven {
        mavenSampleProjects.forEach { projectName ->
            create("${projectName}-sample") {
                repo.set("junit-team/junit5-samples")
                dir.set(projectName)
                options.gitCommitExtraArgs.set(gitCommitArgs)
            }
        }
    }
}
