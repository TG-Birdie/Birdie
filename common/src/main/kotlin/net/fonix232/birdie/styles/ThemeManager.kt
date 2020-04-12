package net.fonix232.birdie.styles

import kotlinx.css.CSSBuilder

interface ThemeManager {
    fun getCurrentTheme(): CSSBuilder.() -> Unit
}