package com.doe.compshop.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Product Table")
data class Product(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    val id: Int,

    @ColumnInfo(name = "Name")
    val name: String,

    @ColumnInfo(name = "Price")
    val price: String,

    @ColumnInfo(name = "Description")
    val description: String,

    @ColumnInfo(name = "ImageUrl")
    val imageUrl: Int?, //or String

    @ColumnInfo(name = "Category")
    val category: String,

    @ColumnInfo(name = "Spec")
    val spec: String?,

    @ColumnInfo(name = "In_Stock")
    val inStock: Boolean,

    @ColumnInfo(name = "Model_Number")
    val modelNumber: String


)