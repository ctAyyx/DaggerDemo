package com.ct.dagger.module

import com.ct.dagger.vo.impl.Pear
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import javax.inject.Named

/**
 *
 * 需要外部传入参数
 *
 * */
@Module
class PearModule(var name: String) {

    @Provides
    fun getPear() = Pear(name)


    @Named("QL")
    @Provides
    fun getPear2(@Named("PearName") pearName: String) = Pear(pearName)


    /**
     * 将下面的数据放入一个Map集合,在对应的Component中将该Map暴露出去
     * */

    @StringKey("XL")
    @IntoMap
    @Provides
    fun buildXL() = Pear("雪梨")

    @StringKey("QL")
    @IntoMap
    @Provides
    fun buildQL() = Pear("青梨")

    @StringKey("HL")
    @IntoMap
    @Provides
    fun buildHL() = Pear("黄梨")
}