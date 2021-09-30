package br.com.multalpha.aplicativos.v1.subscribersapp.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by João Bosco on 28/09/2021.
 * e-mail - Support: ti.junior@gmail.com
 */

@Entity(tableName = "subscriber")
data class SubscriberEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val email: String
)