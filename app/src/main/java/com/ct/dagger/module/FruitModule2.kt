package com.ct.dagger.module

import com.ct.dagger.vo.Fruit
import com.ct.dagger.vo.impl.Apple
import dagger.Binds
import dagger.Module
import javax.inject.Named

/**
 * 如果依赖的Module拥有相同返回的数据
 * 则 需要使用@Named重新定义命名空间
 * */
@Module(includes = [FruitModule::class])
abstract class FruitModule2 {

    /**
     * 如果 传入的对象的构造函数是需要参数的 需要再一个Module中提供
     *
     * 如果该Module中由多个相同对象的返回 可以再参数上加上@Named注解
     * */
    @Named("QPG")
    @Binds
    abstract fun getFruit(@Named("QPG") apple: Apple): Fruit

    @Named("XX")
    @Binds
    abstract fun getFruit2(apple: Apple): Fruit
}