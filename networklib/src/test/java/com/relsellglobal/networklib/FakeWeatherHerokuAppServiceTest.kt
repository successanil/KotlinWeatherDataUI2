package com.relsellglobal.networklib

import com.google.common.truth.Truth
import com.relsellglobal.networklib.fakes.FakeWeatherHerokuAppService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

class FakeWeatherHerokuAppServiceTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `should be able to fetch CityContentNetwork List` () = runTest {
        val data = FakeWeatherHerokuAppService.getWeatherDataCityList()
        Truth.assertThat(data).isNotNull()
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `should be able to fetch CityContentNetwork List For WorkManager` () = runTest {
        val data = FakeWeatherHerokuAppService.getWeatherDataCityListForWorkManager()
        Truth.assertThat(data).isNotNull()
    }


}