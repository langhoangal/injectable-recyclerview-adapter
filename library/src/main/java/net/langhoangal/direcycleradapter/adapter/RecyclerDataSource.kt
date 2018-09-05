package net.langhoangal.direcycleradapter.adapter

import android.annotation.SuppressLint
import android.support.annotation.LayoutRes
import android.support.annotation.MainThread
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import net.langhoangal.direcycleradapter.item.ItemRenderer
import net.langhoangal.direcycleradapter.item.RecyclerItem
import java.lang.ref.WeakReference
import java.util.ArrayList
import java.util.HashMap

class RecyclerDataSource(
    private val renderers: Map<String, ItemRenderer<out RecyclerItem>>
) {
  @SuppressLint("UseSparseArrays")
  private val viewTypeToRendererKeyMap = HashMap<Int, String>()
  private val data = ArrayList<RecyclerItem>()
  private var adapterReference = WeakReference<RecyclerView.Adapter<*>>(null)

  internal val count: Int
    get() = data.size

  init {
    for ((key, value) in renderers) {
      viewTypeToRendererKeyMap[value.layoutRes()] = key
    }
  }

  @MainThread
  fun setData(newData: List<RecyclerItem>) {
    val diffResult = DiffUtil.calculateDiff(
        RecyclerDiffCallback(data, newData))
    data.clear()
    data.addAll(newData)
    val adapter = adapterReference.get()
    if (adapter != null) {
      diffResult.dispatchUpdatesTo(adapter)
    }
  }

  internal fun rendererForType(viewType: Int): ItemRenderer<RecyclerItem> {
    return renderers[viewTypeToRendererKeyMap[viewType]] as ItemRenderer<RecyclerItem>
  }

  @LayoutRes
  internal fun viewResourceForPosition(position: Int): Int {
    return renderers[data[position].renderKey()]!!.layoutRes()
  }

  internal fun getItem(position: Int): RecyclerItem {
    return data[position]
  }

  internal fun attachToAdapter(adapter: RecyclerView.Adapter<*>) {
    adapterReference = WeakReference(adapter)
  }

}
