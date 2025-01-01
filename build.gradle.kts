buildscript {
	dependencies {
		classpath("org.postgresql:postgresql:42.7.1")
		classpath("org.flywaydb:flyway-database-postgresql:11.1.0")
	}
}

plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.4.1"
	id("io.spring.dependency-management") version "1.1.6"
	id ("org.flywaydb.flyway") version "11.1.0"
	//kotlin("plugin.jp") version "1.9.25"
}

group = "arduino"
version = "latest"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("com.fazecast:jSerialComm:2.11.0")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
	implementation ("org.postgresql:postgresql")
	implementation ("org.flywaydb:flyway-core")
	implementation ("io.github.oshai:kotlin-logging-jvm:7.0.0")
	runtimeOnly("org.flywaydb:flyway-database-postgresql:11.1.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation ("com.h2database:h2")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("org.testcontainers:testcontainers:1.20.4")
	testImplementation("org.testcontainers:junit-jupiter:1.20.4")
	testImplementation("org.testcontainers:postgresql:1.20.4")
	testImplementation("org.springframework.boot:spring-boot-testcontainers")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

allOpen {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.named<org.springframework.boot.gradle.tasks.bundling.BootBuildImage>("bootBuildImage") {
	// defining java version and disabling spring cloud bindings because there is bug when downloading it
	environment.put("BP_JVM_VERSION", "21")
	environment.put("BP_SPRING_CLOUD_BINDINGS_DISABLED", "true")
	environment.put("BPL_SPRING_CLOUD_BINDINGS_DISABLED", "true")
}

flyway {
	url = "jdbc:postgresql://localhost:5432/postgres"
	user = "postgres"
	password = "postgres"
	schemas = arrayOf("public")
}
