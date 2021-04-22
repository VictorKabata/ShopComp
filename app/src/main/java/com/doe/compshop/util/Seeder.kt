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
                "BenQ PD3200U",
                667.39,
                "A massive 32-inch Ultra HD display. 3D designers particularly love this display, thanks to the factory-calibrated color accuracy and CAD/CAM mode.",
                R.drawable.monitor1,
                MONITORS,
                "3840 x 2160 display",
                true,
                "BQPD3200U"
            ),

            Product(
                0,
                "LG UltraGear",
                1939.99,
                "If you’re looking for the ultimate gaming monitor, this is certainly the one to beat, with a 144Hz refresh rate that can be easily overclocked to 160Hz.",
                R.drawable.monitor2,
                MONITORS,
                "3840 x 2160 display",
                false,
                "38GN950"
            ),

            Product(
                0,
                "Asus ROG Swift",
                3675.84,
                "The Asus ROG Swift PG27UQ combines so many high-end features that it almost seems like too much",
                R.drawable.monitor3,
                MONITORS,
                "3840 x 2160 display",
                true,
                "PG27UQ"
            ),

            Product(
                0,
                "Dell 4K S3221QS Curved Monitor",
                3675.84,
                "Its simple yet elegant silver design gives it a unique look that sets it apart from all the gamer-centric or boring black office monitors you're most likely to find.",
                R.drawable.monitor4,
                MONITORS,
                "3840 x 2160 display",
                false,
                "S3221QS"
            ),

            Product(
                0,
                "Dell UltraSharp UP3218K",
                3995.0,
                "The Dell UltraSharp UP3218K is aimed at professionals, obviously, so if that sounds like it’s made for you, it’s probably the best monitor you’ll ever find.",
                R.drawable.monitor5,
                MONITORS,
                "7680 x 4320 display",
                true,
                "UP3218K"
            ),

            //endregion

            //region $ProcessorsProduct
            Product(
                0,
                "AMD Ryzen 9 5900X",
                549.0,
                "The AMD Ryzen 9 5900X brings the biggest gen-on-gen jump in a single performance in years, making it a terrific upgrade.",
                R.drawable.processor1,
                PROCESSORS,
                "Base clock: 3.7GHz Boost clock: 4.8GHz",
                false,
                "Ryzen 5000 Series"
            ),

            Product(
                0,
                "AMD Ryzen 9 3950X",
                724.99,
                "The highest tier in the Ryzen 3000 series is the performance powerhouse you’re looking for, if you want something for heavily threaded computer work.",
                R.drawable.processor2,
                PROCESSORS,
                "Base clock: 3.5GHz Boost clock: 4.7GHz",
                false,
                "Ryzen 3000 Series"
            ),

            Product(
                0,
                "AMD Ryzen 5 3600X",
                199.99,
                "With more threads than the Intel Core i5-9600K, this mid-range graphics card delivers impressive multi-threading performance.",
                R.drawable.processor3,
                PROCESSORS,
                "Base clock: 3.8GHz Boost clock: 4.4GHz",
                true,
                "Ryzen 5000 Series"
            ),

            Product(
                0,
                "Intel Core i5-10600K",
                629.0,
                "Mid-range buyers will appreciate the fact that they actually don’t have to shell out quite a bit of cash for Intel’s hyper-threading technology.",
                R.drawable.processor4,
                PROCESSORS,
                "Base clock: 3.5GHz Boost clock: 4.7GHz",
                true,
                "i5 10th Gen"
            ),

            //endregion

            //region $GraphicCardsProduct
            Product(
                0,
                "Nvidia GeForce RTX 3080",
                1199.0,
                "This is both an absolute powerhouse of a graphics card and a great value.",
                R.drawable.graphics_card1,
                GRAPHIC_CARDS,
                "10 GB GDDR6X",
                false,
                "RTX 30 Series"
            ),

            Product(
                0,
                "GeForce RTX 3060 Ti",
                759.0,
                "This graphics card punches way above its weight class, delivering a performance that could rival that of the RTX 2080 Super.",
                R.drawable.graphics_card2,
                GRAPHIC_CARDS,
                "8 GB GDDR6",
                false,
                "RTX 30 Series"
            ),

            Product(
                0,
                "Nvidia GeForce RTX 3090",
                1250.0,
                "With a whopping 24GB of RAM, no game or, more importantly, heavy graphics project will suffer performance issues.",
                R.drawable.graphics_card3,
                GRAPHIC_CARDS,
                "24 GB GDDR6X",
                false,
                "RTX 30 Series"
            ),

            Product(
                0,
                "AMD Radeon RX 5600 XT",
                919.99,
                "This AMD card beats the Nvidia GeForce RTX 2060 with its more affordable price tag, delivering high frame rates.",
                R.drawable.graphics_card4,
                GRAPHIC_CARDS,
                "11GB GDDR5X",
                true,
                "Radeon 5000 Series"
            ),

            Product(
                0,
                "Nvidia GeForce RTX 3070",
                979.99,
                "Latest high performance graphics card for hardcore gamers and graphic designers.",
                R.drawable.graphics_card5,
                GRAPHIC_CARDS,
                "8 GB GDDR6",
                true,
                "RTX 30 Series"
            ),

            //endregion

            //region $StorageProduct

            Product(
                0,
                "Samsung 970 Evo Plus",
                55.99,
                "The Samsung 970 Evo Plus is simply one of the fastest drives on the market, but the fact that Samsung is selling it at such a bargain price is just the icing on the cake.",
                R.drawable.storage1,
                STORAGE,
                "250GB/500GB/1TB/2TB",
                true,
                "EVO Series"
            ),

            Product(
                0,
                "Corsair MP400",
                109.99,
                "With low prices even for SATA SSDs, the Corsair MP400 is offering a ton of storage so you get the most for your money.",
                R.drawable.storage2,
                STORAGE,
                "1TB/2TB/4TB/8TB",
                true,
                "MP400"
            ),

            Product(
                0,
                "Intel Optane 905P",
                250.99,
                "With a random read rated at 575,000 IOPS and random write rated at 555,000 IOPs, it’s definitely one of Intel’s fastest drives.",
                R.drawable.storage3,
                STORAGE,
                "1.5tb",
                true,
                "905P"
            ),

            Product(
                0,
                "Samsung 970 Pro",
                156.29,
                "The Samsung 970 Evo is still the best SSD you can buy if you’re after raw speed.",
                R.drawable.storage4,
                STORAGE,
                "512GB/1TB",
                true,
                "900 Series"
            ),

            //endregion

        )
    }

}