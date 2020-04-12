import java.io.FileFilter

rootProject.name = "Birdie"
include("app", "common")

val pluginsDir = File("${rootDir.path}/plugins")
for(file in pluginsDir.listFiles(FileFilter { it.isDirectory }) ?: arrayOf()) {
//    includeBuild("plugins/${file.name}") {
//
//        dependencySubstitution {
////            substitute(module(Dependencies.Birdie.Common.module))
////                .with(project(Dependencies.Birdie.Common.project))
//        }
//    }
    include("plugins:${file.name}")
}