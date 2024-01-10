buildscript {
    extra.apply {
        set("activity_compose_version", "1.6.1")
        set("compose_ui_version", "1.3.2")
        set("kotlin_version", "1.8.1")
        set("nav_version", "2.5.3")
        set("coil_version", "2.2.0")
        set("hilt_version", "2.44")
        set("timber_version", "5.0.1")
        set("lifecycle_version", "2.6.1")
        set("retrofit_version", "2.9.0")
        set("compose_ui_version", "1.3.2")
        set("activity_compose_version", "1.6.1")
        set("compose_material_version", "1.0.1")
        set("gson_version", "2.10.1")
    }
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.3.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.1")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")
        classpath("com.google.dagger:hilt-android-gradle-plugin:$2.44")
    }
}
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
}