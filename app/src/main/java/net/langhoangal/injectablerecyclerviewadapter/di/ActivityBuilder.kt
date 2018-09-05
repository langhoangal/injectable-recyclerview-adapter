package net.langhoangal.injectablerecyclerviewadapter.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.langhoangal.injectablerecyclerviewadapter.demo.DemoActivity
import net.langhoangal.injectablerecyclerviewadapter.demo.DemoActivityModule

@Module
abstract class ActivityBuilder {

  @ContributesAndroidInjector(modules = [DemoActivityModule::class])
  abstract fun bindDemoActivity(): DemoActivity

}