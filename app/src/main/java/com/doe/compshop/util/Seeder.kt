package com.doe.compshop.util

import com.doe.compshop.R
import com.doe.compshop.models.Product
import com.doe.compshop.util.Constants.GRAPHIC_CARDS
import com.doe.compshop.util.Constants.MONITORS
import com.doe.compshop.util.Constants.PROCESSORS
import com.doe.compshop.util.Constants.STORAGE

class Seeder {

    fun fetchProducts(): MutableList<Product> {
        return mutableListOf(

            //region $MonitorsProduct
            Product(
                0,
                "Samsung",
                "45, 000",
                "55' inch QLED screen that supports 4K",
                R.drawable.ic_launcher_background,
                MONITORS,
                "3840 x 2160 display",
                true,
                "UE55TU8510UXXU"
            ),

            Product(
                0,
                "Samsung",
                "45, 000",
                "55' inch QLED screen that supports 4K",
                R.drawable.ic_launcher_background,
                MONITORS,
                "3840 x 2160 display",
                true,
                "UE55TU8510UXXU"
            ),

            Product(
                0,
                "Samsung",
                "45, 000",
                "55' inch QLED screen that supports 4K",
                R.drawable.ic_launcher_background,
                MONITORS,
                "3840 x 2160 display",
                true,
                "UE55TU8510UXXU"
            ),

            Product(
                0,
                "Samsung",
                "45, 000",
                "55' inch QLED screen that supports 4K",
                R.drawable.ic_launcher_background,
                MONITORS,
                "3840 x 2160 display",
                true,
                "UE55TU8510UXXU"
            ),

            Product(
                0,
                "Samsung",
                "45, 000",
                "55' inch QLED screen that supports 4K",
                R.drawable.ic_launcher_background,
                MONITORS,
                "3840 x 2160 display",
                true,
                "UE55TU8510UXXU"
            ),

            //endregion

            //region $ProcessorsProduct
            Product(
                0,
                "Intel i7",
                "12, 500",
                "Cutting edge processor technology to make you user every core",
                R.drawable.ic_launcher_background,
                PROCESSORS,
                "8 cores",
                true,
                "i7 10900HK"
            ),

            Product(
                0,
                "Intel i7",
                "12, 500",
                "Cutting edge processor technology to make you user every core",
                R.drawable.ic_launcher_background,
                PROCESSORS,
                "8 cores",
                true,
                "i7 10900HK"
            ),

            Product(
                0,
                "Intel i7",
                "12, 500",
                "Cutting edge processor technology to make you user every core",
                R.drawable.ic_launcher_background,
                PROCESSORS,
                "8 cores",
                true,
                "i7 10900HK"
            ),

            Product(
                0,
                "Intel i7",
                "12, 500",
                "Cutting edge processor technology to make you user every core",
                R.drawable.ic_launcher_background,
                PROCESSORS,
                "8 cores",
                true,
                "i7 10900HK"
            ),

            Product(
                0,
                "Intel i7",
                "12, 500",
                "Cutting edge processor technology to make you user every core",
                R.drawable.ic_launcher_background,
                PROCESSORS,
                "8 cores",
                true,
                "i7 10900HK"
            ),

            Product(
                0,
                "Intel i7",
                "12, 500",
                "Cutting edge processor technology to make you user every core",
                R.drawable.ic_launcher_background,
                PROCESSORS,
                "8 cores",
                true,
                "i7 10900HK"
            ),
            //endregion

            //region $GraphicCardsProduct
            Product(
                0,
                "RTX 3060",
                "18, 500",
                "Latest high performance graphics card for hardcore gamers and graphic designers.",
                R.drawable.ic_launcher_background,
                GRAPHIC_CARDS,
                "8GB VRAM",
                true,
                "RTX 30 Series"
            ),

            Product(
                0,
                "RTX 3060",
                "18, 500",
                "Latest high performance graphics card for hardcore gamers and graphic designers.",
                R.drawable.ic_launcher_background,
                GRAPHIC_CARDS,
                "8GB VRAM",
                true,
                "RTX 30 Series"
            ),

            Product(
                0,
                "RTX 3060",
                "18, 500",
                "Latest high performance graphics card for hardcore gamers and graphic designers.",
                R.drawable.ic_launcher_background,
                GRAPHIC_CARDS,
                "8GB VRAM",
                true,
                "RTX 30 Series"
            ),

            Product(
                0,
                "RTX 3060",
                "18, 500",
                "Latest high performance graphics card for hardcore gamers and graphic designers.",
                R.drawable.ic_launcher_background,
                GRAPHIC_CARDS,
                "8GB VRAM",
                true,
                "RTX 30 Series"
            ),

            Product(
                0,
                "RTX 3060",
                "18, 500",
                "Latest high performance graphics card for hardcore gamers and graphic designers.",
                R.drawable.ic_launcher_background,
                GRAPHIC_CARDS,
                "8GB VRAM",
                true,
                "RTX 30 Series"
            ),

            //endregion

            //region $StorageProduct

            Product(
                0,
                "Samsung SSD",
                "15, 500",
                "High performance solid state drive that has extremely fast read write capability.",
                R.drawable.ic_launcher_background,
                STORAGE,
                "2TB",
                true,
                "EVO Series"
            ),

            Product(
                0,
                "Samsung SSD",
                "15, 500",
                "High performance solid state drive that has extremely fast read write capability.",
                R.drawable.ic_launcher_background,
                STORAGE,
                "2TB",
                true,
                "EVO Series"
            ),

            Product(
                0,
                "Samsung SSD",
                "15, 500",
                "High performance solid state drive that has extremely fast read write capability.",
                R.drawable.ic_launcher_background,
                STORAGE,
                "2TB",
                true,
                "EVO Series"
            ),

            Product(
                0,
                "Samsung SSD",
                "15, 500",
                "High performance solid state drive that has extremely fast read write capability.",
                R.drawable.ic_launcher_background,
                STORAGE,
                "2TB",
                true,
                "EVO Series"
            ),

            //endregion

        )
    }

}