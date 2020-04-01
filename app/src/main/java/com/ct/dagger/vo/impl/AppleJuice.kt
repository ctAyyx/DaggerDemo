package com.ct.dagger.vo.impl

import com.ct.dagger.vo.Juice
import javax.inject.Inject

/**
 * 构建 苹果汁对象
 * */
class AppleJuice @Inject constructor(var apple: Apple) : Juice {
    override fun getJuiceName(): String = "一杯${apple.name}汁"
}