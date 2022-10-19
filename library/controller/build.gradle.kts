plugins {
    id("java")
}

group = "ru.vk"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

    implementation("com.intellij:annotations:12.0")
    implementation("org.projectlombok:lombok:1.18.22")
    implementation("org.hibernate:hibernate-gradle-plugin:5.6.12.Final")
    implementation("com.h2database:h2:2.1.212")
    implementation("com.google.code.gson:gson:2.7")

    implementation(project(":models"))
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}