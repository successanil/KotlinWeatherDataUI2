package com.relsellglobal.networklib

import com.google.common.truth.Truth
import com.relsellglobal.networklib.fakes.FakeWeatherHerokuAppService
import kotlinx.coroutines.test.runTest
import org.junit.Test

class FakeWeatherHerokuAppServiceTest {

    @Test
    fun `should be able to fetch CityContentNetwork List` () = runTest {
        val data = FakeWeatherHerokuAppService.getWeatherDataCityList()
        Truth.assertThat(data).isNotNull()
    }
}