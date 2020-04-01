package com.ct.dagger.module

import com.ct.dagger.vo.impl.Apple
import com.ct.dagger.vo.impl.AppleJuice
import dagger.Module
import dagger.Provides

@Module
class JuiceModule {

    /**
     * 提供苹果汁
     * */
    @Provides
    fun getAppleJuice(apple: Apple) = AppleJuice(apple)


}