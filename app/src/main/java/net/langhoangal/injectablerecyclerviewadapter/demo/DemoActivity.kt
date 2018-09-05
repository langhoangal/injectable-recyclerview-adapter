package net.langhoangal.injectablerecyclerviewadapter.demo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.WorkSource
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import dagger.android.AndroidInjection
import net.langhoangal.direcycleradapter.adapter.RecyclerAdapter
import net.langhoangal.direcycleradapter.adapter.RecyclerDataSource
import net.langhoangal.injectablerecyclerviewadapter.R
import net.langhoangal.injectablerecyclerviewadapter.R.layout
import net.langhoangal.injectablerecyclerviewadapter.demo.model.ImageItem
import net.langhoangal.injectablerecyclerviewadapter.demo.model.TextItem
import javax.inject.Inject

class DemoActivity : AppCompatActivity() {

  @Inject
  lateinit var dataSource: RecyclerDataSource

  @BindView(R.id.rvDemo)
  lateinit var rvDemo: RecyclerView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    AndroidInjection.inject(this)
    setContentView(layout.activity_demo)
    ButterKnife.bind(this)

    val adapter = RecyclerAdapter(dataSource)
    rvDemo.adapter = adapter
    rvDemo.layoutManager = LinearLayoutManager(this)

    // create list of item
    val item1 = TextItem(0, "This is text item 1")
    val item2 = TextItem(0, "This is text item 2")
    val item3 = ImageItem(0, "http://www.hdfinewallpapers.com/assets/img/logo.png")
    val item4 = TextItem(0, "This is text item 3")
    val item5 = ImageItem(0, "https://5.imimg.com/data5/BG/UO/GLADMIN-15311298/computer-science-250x250.jpg")
    val item6 = TextItem(0, "This is text item 4")
    val item7 = ImageItem(0, "https://5.imimg.com/data5/OO/SF/GLADMIN-12407517/styrene-acrylic-emulsions-250x250.png")
    val item8 = ImageItem(0, "https://3.imimg.com/data3/FO/SL/MY-3426567/a-global-player-with-a-strong-local-presence-250x250.jpg")

    dataSource.setData(listOf(item1, item2, item3, item4, item5, item6, item7, item8))
  }

}
