package net.langhoangal.direcycleradapter.adapter

import android.support.v7.util.DiffUtil

import net.langhoangal.direcycleradapter.item.RecyclerItem

class RecyclerDiffCallback
internal constructor(
    private val oldList: List<RecyclerItem>,
    private val newList: List<RecyclerItem>
) : DiffUtil.Callback() {

  override fun getOldListSize(): Int {
    return oldList.size
  }

  override fun getNewListSize(): Int {
    return newList.size
  }

  override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
    return oldList[oldItemPosition].getItemId() == newList[newItemPosition].getItemId()
  }

  override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
    return oldList[oldItemPosition] == newList[newItemPosition]
  }
}
