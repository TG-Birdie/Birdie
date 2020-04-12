data class Dependency(val groupId: String, val artifactId: String, val version: String) {
    val fullName: String
        get() = "$groupId:$artifactId:$version"

    val module: String
        get() = "$groupId:$artifactId"

    val project: String
        get() = ":$artifactId"
}