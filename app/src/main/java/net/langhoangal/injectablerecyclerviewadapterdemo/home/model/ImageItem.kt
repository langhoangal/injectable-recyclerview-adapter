package net.langhoangal.injectablerecyclerviewadapterdemo.home.model

import net.langhoangal.direcycleradapter.item.RecyclerItem

class ImageItem internal constructor(var id: Long, var message: String) : RecyclerItem {

  override fun getItemId() = id

  override fun renderKey() = "ImageItem"

}