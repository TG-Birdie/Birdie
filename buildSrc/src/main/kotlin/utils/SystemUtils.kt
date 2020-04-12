package utils

import java.util.Locale
import org.gradle.internal.os.OperatingSystem

/**
 * Util to check if the project run on Linux or Mac operating system
 *
 * @return true if the operating system is one of them
 */
fun isLinuxOrMacOs(): Boolean {
    return OperatingSystem.current().run { isLinux || isUnix || isMacOsX }
}