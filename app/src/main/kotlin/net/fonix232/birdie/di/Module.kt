package net.fonix232.birdie.di

import net.fonix232.birdie.styles.ThemeManager
import net.fonix232.birdie.styles.ThemeManagerImpl
import org.koin.dsl.module

val appModule = module {
    single<ThemeManager> { ThemeManagerImpl() }
}