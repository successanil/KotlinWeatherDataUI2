package com.relsellglobal.modelslib

import com.relsellglobal.modelslib.DummyTest
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DummyClassTest {
    @Test
    fun test_CallingDoSomethingMethod() {
        var dObj = DummyTest()
        assertEquals("doSmartThing called",dObj.doSmartThing())
    }
}