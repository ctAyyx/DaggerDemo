package com.ct.dagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import com.ct.dagger.component.DaggerFruitComponent
import com.ct.dagger.module.PearModule

import com.ct.dagger.vo.Shop
import dagger.MapKey
import dagger.multibindings.StringKey
import javax.inject.Inject


/**
 * Dagger2的使用
 *
 * 注解大全: https://www.jianshu.com/p/6a65b9d33fea
 *
 * @Inject 可以用于对类的构造函数、成员变量和方法
 *         用于构造函数:表示该类在依赖注入时使用被注解的构造器创建对象(一个对象只能有一个构造函数被标记)
 *         用于成员变量:表示该成员变量作为依赖需要被注入(不能被private final修饰)
 *         用于方法:表示依赖于方法参数的类型会被注入(不能被private修饰)
 *
 * @Providers 表示提供依赖的方法,需要放在被@Module修饰的类中,不能和@Binds一起
 * @Binds 使用@Binds标注的方法必须有且仅有一个方法参数,且这个方法参数是方法返回值的实现类或者子类,注解的方法为抽象方法
 *
 * @Component 注解的类必须是接口或者抽象类,被注解的类可以包含以下三个部分
 *         表示提供的依赖的方法
 *            SomeType getSomeType();// 表示需要注入依赖生成SomeType类对象
 *         表示注入成员依赖的方法
 *            void injectSomeType(SomeType someType);// 表示需要将someType中标记为依赖的属性和方法进行注入
 *         构造Component的Builder
 *            这个看实际例子
 * @Component 的dependencies和 @SubComponent
 *
 * @Qualifier 限定符,元注解.参考@Named的使用
 *
 * @Scope 元注解,告诉注入器要注意对象的重用的生命周期.参考@Singleton,@Reusable
 *        @Singleton 单例模式
 *        @Reusable  缓存模式
 *
 * Lazy,Provider 依赖注入有三种模式：
 *               直接注入（Direct Injection）:直接注入模式下，被注入的对象会先生成，然后当有需要被注入的地方时，将预先生成的对象赋值到需要的地方.
 *               还有就是懒注入（Lazy Injection）: Lazy注入只有当get的时候才会创建对象，且生成之后对象会被缓存下来.
 *               和提供者注入（Provider Injection）:  Provider注入在每次get都会创建新的对象.
 * @BindsInstance 给Component传递参数有两种方式
 *               通过构建Module时在Module的构造函数中传入参数
 *               通过@BindsInstance,通过Component.Builder来构建Component
 *
 * @BindsOptionOf 注解方法 表示绑定是可选的 如果有需要注入的 就会出现 没有需要注入的就会消失
 *
 * @MapKey 元注解,Map集合的Key标记,标记Map集合的Key类型
 *         @StringKey @IntKey @LongKey @ClassKey @AndroidInjectKey
 * @IntoMap 将方法的返回类型和给定的MapKey放入Map集合,@intoMap需要和@provides及@binds之类的注解配合使用
 * */
class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var shop: Shop

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //DaggerFruitComponent.create().inject(this)
        //针对dependence的使用
//        DaggerJuiceComponent.builder()
//            .fruitComponent(DaggerFruitComponent.create())
//            .build()
//            .inject(this)

        //针对Subcomponent的使用
        //1.显示的在被依赖的Component中返还被Subcomponent修饰Component
        //这里我们在FruitComponent中显示的返回JuiceComponent
        //DaggerFruitComponent.create().buildJuiceComponent().inject(this)

        //2.在Module中指定可以为那些Component提供依赖
        //  并在该Component中添加被@Subcomponent.Builder注解注释的Builder接口,方法名为build
        //这里我们在FruitModule中指定可以为JuiceComponent提供依赖，在JuiceComponent中添加Builder接口

//        shop = DaggerFruitComponent.create().getShop()
//        shop.getJuiceComponent(this)

        //从外部传入参数
        shop = DaggerFruitComponent.builder()
            .setPearName("冰糖雪梨")
            .pearModule(PearModule("雪梨"))
            .build().getShop()
        shop.getJuiceComponent(this)

    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btn_dagger_simple -> daggerSimple()
            R.id.btn_dagger_dependencies -> showFruit()
            R.id.btn_dagger_param -> showPear()
            R.id.btn_dagger_map->showPearMap()
        }
    }

    private fun daggerSimple() {
        shop.showFruit()

    }


    private fun showFruit() {
        shop.showJuice()
    }


    private fun showPear() {
        shop.showPear()
    }

    private fun showPearMap(){
        shop.showPearMap()

    }
}
