package net.langhoangal.direcycleradapter.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import net.langhoangal.direcycleradapter.item.ItemRenderer
import net.langhoangal.direcycleradapter.item.RecyclerItem

class RecyclerViewHolder(
    parent: ViewGroup,
    private val renderer: ItemRenderer<RecyclerItem>
) : RecyclerView.ViewHolder(renderer.createView(parent)) {

  internal fun bind(item: RecyclerItem) {
    renderer.render(itemView, item, adapterPosition)
  }

}
