plugins {
    kotlin("jvm") version "1.8.20"
    application
}

group = "org.example"
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

kotlin {
    jvmToolchain(11)
}

val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask<*> by tasks
compileKotlin.compilerOptions.freeCompilerArgs.add("-Xcontext-receivers")

application {
    mainClass.set("com.bignerdranch.nyethack.MainKt")
}