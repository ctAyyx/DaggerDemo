package com.ct.dagger.vo.impl

import com.ct.dagger.vo.Fruit
import org.jetbrains.annotations.NotNull
import javax.inject.Inject

class Apple @Inject constructor(var name: String) : Fruit {
    override fun getFruitName(): String = name
}