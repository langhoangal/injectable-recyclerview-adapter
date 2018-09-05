package net.langhoangal.injectablerecyclerviewadapter.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import net.langhoangal.injectablerecyclerviewadapter.MyApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [
  AndroidInjectionModule::class,
  ActivityBuilder::class
])
interface AppComponent {

  @Component.Builder
  interface Builder {

    @BindsInstance
    fun application(application: Application): Builder

    fun build(): AppComponent

  }

  fun inject(application: MyApplication)

}