package com.doe.compshop

import android.app.Application
import com.doe.compshop.util.Seeder
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CompShop : Application(){

    override fun onCreate() {
        super.onCreate()

        //Seeder().fetchProducts() //Seeds the list on app start
    }

}