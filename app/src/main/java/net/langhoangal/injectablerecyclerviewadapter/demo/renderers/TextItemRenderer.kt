package net.langhoangal.injectablerecyclerviewadapter.demo.renderers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import net.langhoangal.direcycleradapter.item.ItemRenderer
import net.langhoangal.injectablerecyclerviewadapter.R
import net.langhoangal.injectablerecyclerviewadapter.demo.model.TextItem
import javax.inject.Inject

class TextItemRenderer @Inject internal constructor() : ItemRenderer<TextItem> {

  override fun layoutRes() = R.layout.view_holder_text_item

  override fun createView(parent: ViewGroup): View {
    val view = LayoutInflater.from(parent.context).inflate(layoutRes(), parent, false)
    view.tag = ViewBinder(view)
    return view
  }

  override fun render(itemView: View, item: TextItem, position: Int) {
    (itemView.tag as ViewBinder).bind(item)
  }

  internal class ViewBinder(itemView: View) {

    @BindView(R.id.tvMessage)
    internal lateinit var tvMessage: TextView

    init {
      ButterKnife.bind(this, itemView)
    }

    fun bind(item: TextItem) {
      tvMessage.text = item.message
    }
  }
}