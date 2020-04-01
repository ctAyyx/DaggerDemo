package com.ct.dagger.component

import com.ct.dagger.module.FruitModule
import com.ct.dagger.module.PearModule
import com.ct.dagger.vo.Shop
import com.ct.dagger.vo.impl.Apple
import com.ct.dagger.vo.impl.Pear
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@Component(modules = [FruitModule::class, PearModule::class])
interface FruitComponent {

    /**
     * 对于 Dependence
     * 显示的提供依赖 在JuiceComponent 依赖该Component的时候 才能获取Apple对象
     * */
    fun getApple(): Apple


    /**对于 Subcomponent的使用
     *  在依赖的Component中显示的返回该Component
     * */
    //fun buildJuiceComponent(): JuiceComponent

    fun getShop(): Shop



    /**
     * 需要外部传入参数
     * 使用@BindsInstance
     * */
    @Component.Builder
    interface Builder {

        /**
         *  @BindsInstance 来表示需要传入的参数
         *  返回值需是该Builder对象
         *
         *  我们可以为参数加上限定符
         * */
        @BindsInstance
        fun setPearName(@Named("PearName") name: String): Builder

        //如果我们依赖的Module是需要参数的 还要显示的提供设置方法
        fun pearModule(pearModule: PearModule): Builder

        fun build(): FruitComponent


    }

}