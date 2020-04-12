object Dependencies {

    object Birdie {
        val GROUP = "net.fonix232.birdie"
        val VERSION = Versions.Birdie

        val Common = Dependency(GROUP, "common", VERSION)

        object Plugins {
            val GROUP = "${Birdie.GROUP}.plugins"
        }
    }

    object KotlinX {
        private val GROUP = "org.jetbrains.kotlinx"

        val HTML = Dependency(GROUP, "kotlinx-html-jvm", "0.7.1")
        val CSS = Dependency("org.jetbrains", "kotlin-css-jvm", "1.0.0-pre.94-kotlin-1.3.70")
    }

    object Ktor {
        private val GROUP = "io.ktor"
        private val VERSION = Versions.Ktor

        object Auth {
            val Basic = Dependency(GROUP, "ktor-auth", VERSION)
            val JWT = Dependency(GROUP, "ktor-auth-jwt", VERSION)
        }

        object Server {
            val Core = Dependency(GROUP, "ktor-server-core", VERSION)
            val Netty = Dependency(GROUP, "ktor-server-netty", VERSION)
            val HostCommon = Dependency(GROUP, "ktor-server-host-common", VERSION)

            val Sessions = Dependency(GROUP, "ktor-server-sessions", VERSION)
        }

        val HtmlBuilder = Dependency(GROUP, "ktor-html-builder", VERSION)

        val GSON = Dependency(GROUP, "ktor-gson", VERSION)
        val Locations = Dependency(GROUP, "ktor-locations", VERSION)
        val Metrics = Dependency(GROUP, "ktor-metrics", VERSION)
        val WebSockets = Dependency(GROUP, "ktor-websockets", VERSION)
    }

    object Logback

    object TelegramBot {
        private final val GROUP = "io.github.kotlin-telegram-bot.kotlin-telegram-bot"

        val Core = Dependency(GROUP, "telegram", "4.6.0")
    }

    object PF4J {
        private final val GROUP = "org.pf4j"
        private final val VERSION = "3.2.0"

        val Core = Dependency(GROUP, "pf4j", VERSION)
        val Web = Dependency(GROUP, "pf4j-web", "1.0.0")
        val Update = Dependency(GROUP, "pf4j-update", "2.3.0")
    }

    object Koin {
        private final val GROUP = "org.koin"
        private final val VERSION = Versions.Koin

        val Core = Dependency(GROUP, "koin-core", VERSION)
        val Ext = Dependency(GROUP, "koin-core-ext", VERSION)
        val Ktor = Dependency(GROUP, "koin-ktor", VERSION)
    }
}