package net.langhoangal.injectablerecyclerviewadapterdemo.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.langhoangal.injectablerecyclerviewadapterdemo.home.HomeActivity
import net.langhoangal.injectablerecyclerviewadapterdemo.home.DemoActivityModule

@Module
abstract class ActivityBuilder {

  @ContributesAndroidInjector(modules = [DemoActivityModule::class])
  abstract fun bindDemoActivity(): HomeActivity

}