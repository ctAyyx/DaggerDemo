package com.ct.dagger.component

import com.ct.dagger.MainActivity
import com.ct.dagger.module.JuiceModule
import dagger.Component
import dagger.Subcomponent

/**
 * 果汁 试图对象
 *
 * 这里我们引入 水果视图对象
 * 这样才可以获取 榨果汁需要的水果对象
 * 有两种模式 Dependencies SubComponent
 * Dependencies:
 *     被引入的Component必须显示提供依赖
 *SubComponent：
 *     被该注解注解的Component表示自身视图不完整,需要依附与其他Component
 *     有两种方式
 *      1.在依赖的Component中显示的返回该Component
 *      2.在Module的subcomponents指定该module可以为那些视图提供依赖
 * */
//@Component(modules = [JuiceModule::class], dependencies = [FruitComponent::class])
@Subcomponent(modules = [JuiceModule::class])
interface JuiceComponent {

    fun inject(activity: MainActivity)
    /**
     * 对于 Subcomponent的使用
     * 在Module的subcomponents指定该module可以为那些视图提供依赖时,需要在Subcomponent中创建由  @Subcomponent.Builder 注解的Builder接口 方法名为build
     * */
    @Subcomponent.Builder
    interface Builder {
        fun build(): JuiceComponent
    }
}