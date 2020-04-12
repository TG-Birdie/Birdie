import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.*
import org.gradle.kotlin.dsl.accessors.runtime.addExternalModuleDependencyTo
import org.gradle.plugin.use.PluginDependenciesSpec

/**
 * Configures the current project as a Kotlin project by adding the Kotlin `stdlib` as a dependency.
 */
fun Project.kotlinProject() {
    dependencies {
        "implementation"(kotlin("stdlib"))
    }
}

inline val PluginDependenciesSpec.shadow: org.gradle.plugin.use.PluginDependencySpec
    get() = id("com.github.johnrengelman.shadow") version "5.0.0"

fun DependencyHandler.implementation(dependency: Dependency) {
    addDep("implementation", dependency)
}

fun DependencyHandler.api(dependency: Dependency) {
    addDep("api", dependency)
}

private fun DependencyHandler.addDep(configurationName: String, dependency: Dependency) {
    addExternalModuleDependencyTo(
        this,
        configurationName,
        dependency.groupId,
        dependency.artifactId,
        dependency.version,
        null,
        null,
        null,
        null
    )
}