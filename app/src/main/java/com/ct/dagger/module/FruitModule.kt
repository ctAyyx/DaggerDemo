package com.ct.dagger.module

import com.ct.dagger.component.JuiceComponent
import com.ct.dagger.vo.Fruit
import com.ct.dagger.vo.impl.Apple
import com.ct.dagger.vo.impl.Orange
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * 对于 Subcomponent的使用
 * 在Module的subcomponent中指定可以为那些SubComponent提供依赖
 * */
@Module(subcomponents = [JuiceComponent::class])//这里可以为JuiceComponent提供依赖
class FruitModule {

    //返回指定类型的数据

    @Provides
    fun getApple() = Apple("苹果")

    @Named("QPG")
    @Provides
    fun getApple2() = Apple("青苹果")

    @Provides
    fun getOrange() = Orange()

    //返回 Fruit类型的数据
    //在这里就可以用Named的区别
    @Provides
    fun getFruit(): Fruit = Apple("红苹果")

    @Provides
    @Named("HFS")
    fun getFruit2(): Fruit = Apple("红富士")


}