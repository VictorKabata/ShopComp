package com.doe.compshop.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "Cart Table")
data class CartProduct(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    val id: Int,

    @ColumnInfo(name = "Name")
    val name: String,

    @ColumnInfo(name = "Price")
    val price: Double,

    @ColumnInfo(name = "Description")
    val description: String,

    @ColumnInfo(name = "ImageUrl")
    val imageUrl: Int?,

    @ColumnInfo(name = "Category")
    val category: String,

    @ColumnInfo(name = "Spec")
    val spec: String?,

    @ColumnInfo(name = "In_Stock")
    val inStock: Boolean,

    @ColumnInfo(name = "Model_Number")
    val modelNumber: String
):Parcelable