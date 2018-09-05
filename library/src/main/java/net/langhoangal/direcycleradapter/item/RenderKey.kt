package net.langhoangal.direcycleradapter.item

import dagger.MapKey

@MapKey
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
annotation class RenderKey(val value: String)
