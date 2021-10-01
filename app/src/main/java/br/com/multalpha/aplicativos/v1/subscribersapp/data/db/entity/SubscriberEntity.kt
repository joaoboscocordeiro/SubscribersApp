package br.com.multalpha.aplicativos.v1.subscribersapp.data.db.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * Created by João Bosco on 28/09/2021.
 * e-mail - Support: ti.junior@gmail.com
 */

@Parcelize
@Entity(tableName = "subscriber")
data class SubscriberEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val email: String
) : Parcelable