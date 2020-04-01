package com.ct.dagger.vo

import android.util.Log
import com.ct.dagger.MainActivity
import com.ct.dagger.component.JuiceComponent
import com.ct.dagger.vo.impl.Apple
import com.ct.dagger.vo.impl.AppleJuice
import com.ct.dagger.vo.impl.Orange
import com.ct.dagger.vo.impl.Pear
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Provider

/**
 * 商店
 * */
class Shop @Inject constructor() {

//    @Inject
//    lateinit var apple: Apple
//
//    @Inject
//    lateinit var orange: Orange


    @Inject
    lateinit var fruit: Fruit


    //这里是对dependence的使用
    @Inject
    lateinit var juice: AppleJuice


    @Inject
    lateinit var pear: Pear //注入Module传入参数的Pear对象

    @Named("QL")
    @Inject
    lateinit var pear2: Pear//注入Component传入参数的Pear对象


    @Inject
    lateinit var pearMap:Map<String,Pear>

    //对于SubComponent
    //在Module中指定可以为那些Subcomponent提供依赖,并在Componet中构建Builder接口
    //这里再FruitModule中指定可以为JuiceComponent提供依赖,再JuiceComponent中构建依赖
    //这里需要获取到
    @Inject
    lateinit var juiceComponentProvider: Provider<JuiceComponent.Builder>


    fun showFruit() {
        //Log.e("TAG", "当前的水果有:${apple.getFruitName()},${orange.getFruitName()}")
        Log.e("TAG", "当前的水果有:${fruit.getFruitName()}")
    }

    fun showJuice() {
        Log.e("TAG", "当前的果汁有:${juice.getJuiceName()}")
    }

    fun showPear() {
        Log.e("TAG", "当前的梨有:${pear.getFruitName()} -- ${pear2.getFruitName()}")
    }
    fun showPearMap() {
        Log.e("TAG", "当前的梨有:${pearMap}")
    }



    fun getJuiceComponent(activity: MainActivity) {
        juiceComponentProvider.get().build()
            .inject(activity)
    }
}