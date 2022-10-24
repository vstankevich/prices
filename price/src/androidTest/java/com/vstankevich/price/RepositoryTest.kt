package com.vstankevich.price

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.vstankevich.price.repository.RandomPriceRepository
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import io.reactivex.rxjava3.schedulers.Schedulers
import junit.framework.Assert.fail
import org.junit.Before
import org.junit.Test

class RepositoryTest {

    private lateinit var repository: RandomPriceRepository

    @Before
    fun setUp() {
        repository = RandomPriceRepository()
    }

    @Test
    fun resumeWithoutGettingPrices() {
        repository.resume()
            .subscribe {
                fail("There aren't any values in resume without getting prices before")
            }
    }
}