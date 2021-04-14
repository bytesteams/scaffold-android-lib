package org.bytesteam.mobile.scaffold.di

import dagger.Module
import org.bytesteam.mobile.scaffold.di.feature.FeatureModule

@Module(includes = [
    FeatureModule::class
])
class AppModule {
}