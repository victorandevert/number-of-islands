
plugins {
    kotlin("jvm") version "1.5.30"
}

group = "number.of.islands"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}