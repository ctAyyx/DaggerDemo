package com.ct.dagger.vo.impl

import com.ct.dagger.vo.Fruit
import javax.inject.Inject

class Orange @Inject constructor(): Fruit {
    override fun getFruitName(): String = "橘子"
}