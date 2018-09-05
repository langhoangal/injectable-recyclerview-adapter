package net.langhoangal.injectablerecyclerviewadapter.demo.renderers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import net.langhoangal.direcycleradapter.item.ItemRenderer
import net.langhoangal.injectablerecyclerviewadapter.R
import net.langhoangal.injectablerecyclerviewadapter.demo.model.ImageItem
import javax.inject.Inject

class ImageItemRenderer @Inject internal constructor() : ItemRenderer<ImageItem> {

  override fun layoutRes() = R.layout.view_holder_image_item

  override fun createView(parent: ViewGroup): View {
    val view = LayoutInflater.from(parent.context).inflate(layoutRes(), parent, false)
    view.tag = ViewBinder(view)
    return view
  }

  override fun render(itemView: View, item: ImageItem, position: Int) {
    (itemView.tag as ViewBinder).bind(item)
  }

  internal class ViewBinder(itemView: View) {

    @BindView(R.id.ivPhoto)
    internal lateinit var ivPhoto: ImageView

    init {
      ButterKnife.bind(this, itemView)
    }

    fun bind(item: ImageItem) {
      Glide.with(ivPhoto).load(item.message).into(ivPhoto)
    }
  }
}