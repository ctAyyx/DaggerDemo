package com.ct.dagger.vo.impl

import com.ct.dagger.vo.Fruit
import javax.inject.Inject

/**
 * 创建 一个Pear对象
 *
 * 该对象需要传入名称
 *
 * 这里我们使用Component里面的参数
 * @BindInstance的使用
 * */
class Pear @Inject constructor(var name: String) : Fruit {

    override fun getFruitName(): String = name

    override fun toString(): String = name
}