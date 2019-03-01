import org.jetbrains.kotlin.cli.common.arguments.K2JsArgumentConstants
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation

plugins {
	kotlin("multiplatform") version "1.3.21"
	id("nebula.release") version "9.2.0"
	id("ru.capjack.capjack-bintray") version "0.16.0"
}

group = "ru.capjack.kt"

repositories {
	jcenter()
}

kotlin {
	sourceSets {
		commonMain {
			dependencies {
				implementation(kotlin("stdlib-common"))
			}
		}
	}
	
	jvm().compilations {
		all {
			kotlinOptions.jvmTarget = "1.8"
		}
		
		get(KotlinCompilation.MAIN_COMPILATION_NAME).defaultSourceSet {
			dependencies {
				implementation(kotlin("stdlib-jdk8"))
			}
		}
	}
	
	js().compilations {
		all {
			kotlinOptions.moduleKind = K2JsArgumentConstants.MODULE_UMD
		}
		
		get(KotlinCompilation.MAIN_COMPILATION_NAME).defaultSourceSet {
			dependencies {
				implementation(kotlin("stdlib-js"))
			}
		}
	}
	
}