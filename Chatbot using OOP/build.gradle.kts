plugins {
    id("java")
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // FreeTTS dependencies
    implementation(files("D:/freetts-1.2.2-bin/freetts-1.2/lib/cmu_time_awb.jar"))
    implementation(files("D:/freetts-1.2.2-bin/freetts-1.2/lib/cmu_us_kal.jar"))
    implementation(files("D:/freetts-1.2.2-bin/freetts-1.2/lib/cmudict04.jar"))
    implementation(files("D:/freetts-1.2.2-bin/freetts-1.2/lib/cmulex.jar"))
    implementation(files("D:/freetts-1.2.2-bin/freetts-1.2/lib/cmutimelex.jar"))
    implementation(files("D:/freetts-1.2.2-bin/freetts-1.2/lib/en_us.jar"))
    implementation(files("D:/freetts-1.2.2-bin/freetts-1.2/lib/freetts.jar"))
    implementation(files("D:/freetts-1.2.2-bin/freetts-1.2/lib/freetts-jsapi10.jar"))
    implementation(files("D:/freetts-1.2.2-bin/freetts-1.2/lib/jsapi.jar"))
    implementation(files("D:/freetts-1.2.2-bin/freetts-1.2/lib/mbrola.jar"))
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("org.example.TextToSpeak")
}

tasks.withType<JavaExec> {
    // Set JVM arguments to include the FreeTTS libraries
    jvmArgs = listOf("-Djava.library.path=${projectDir}/libs")
}
