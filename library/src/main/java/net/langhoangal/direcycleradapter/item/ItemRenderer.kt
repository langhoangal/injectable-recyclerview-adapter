package net.langhoangal.direcycleradapter.item

import android.support.annotation.LayoutRes
import android.view.View
import android.view.ViewGroup

interface ItemRenderer<T : RecyclerItem> {

  @LayoutRes
  fun layoutRes(): Int

  fun createView(parent: ViewGroup): View

  fun render(itemView: View, item: T, position: Int)

}
