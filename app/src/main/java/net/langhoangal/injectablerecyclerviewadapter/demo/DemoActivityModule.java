package net.langhoangal.injectablerecyclerviewadapter.demo;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import java.util.Map;
import net.langhoangal.direcycleradapter.adapter.RecyclerDataSource;
import net.langhoangal.direcycleradapter.item.ItemRenderer;
import net.langhoangal.direcycleradapter.item.RecyclerItem;
import net.langhoangal.direcycleradapter.item.RenderKey;
import net.langhoangal.injectablerecyclerviewadapter.demo.renderers.ImageItemRenderer;
import net.langhoangal.injectablerecyclerviewadapter.demo.renderers.TextItemRenderer;

@Module public abstract class DemoActivityModule {

  @Provides public static RecyclerDataSource provideRecyclerDataSource(
      Map<String, ItemRenderer<? extends RecyclerItem>> renderers) {
    return new RecyclerDataSource(renderers);
  }

  @Binds @IntoMap @RenderKey("TextItem")
  public abstract ItemRenderer<? extends RecyclerItem> bindTextItemRenderer(TextItemRenderer textItemRenderer);

  @Binds @IntoMap @RenderKey("ImageItem")
  public abstract ItemRenderer<? extends RecyclerItem> bindImageItemRenderer(ImageItemRenderer imageItemRenderer);
}
