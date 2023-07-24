plugins {
    id("com.gradle.enterprise") version "3.14"
}

gradleEnterprise {
    server = "https://ge.junit.org"
    buildScan {
        publishAlways()
    }
}

rootProject.name = "junit-wrapper-upgrade"
