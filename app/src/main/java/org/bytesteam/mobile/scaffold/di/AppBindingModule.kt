package org.bytesteam.mobile.scaffold.di

import dagger.Module
import org.bytesteam.mobile.scaffold.di.feature.FeatureBindingModule

@Module(includes = [FeatureBindingModule::class])
abstract class AppBindingModule {
}