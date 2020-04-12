/*
 * This file is part of Birdie (https://github.com/TG-Birdie/Birdie/)
 * Copyright (c) 2020 Jozsef Kiraly <fonix232@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package plugins

import com.github.benmanes.gradle.versions.VersionsPlugin
import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

apply<VersionsPlugin>()

tasks {
    withType<DependencyUpdatesTask> {
        resolutionStrategy {
            componentSelection {
                all {
                    // TODO: Configure acceptable releases
                    val rejected = listOf("alpha", "beta", "rc", "cr", "m", "preview", "b", "ea")
                        .map { qualifier -> Regex("(?i).*[.-]$qualifier[.\\d-+]*") }
                        .any { it.matches(candidate.version) }

                    if (rejected) {
                        reject("Release candidate")
                    }
                }
            }
        }
    }
}
