package br.com.multalpha.aplicativos.v1.subscribersapp.repository

import androidx.lifecycle.LiveData
import br.com.multalpha.aplicativos.v1.subscribersapp.data.db.entity.SubscriberEntity

/**
 * Created by João Bosco on 29/09/2021.
 * e-mail - Support: ti.junior@gmail.com
 */

interface SubscriberRepository {

    suspend fun insertSubscriber(name: String, email: String): Long

    suspend fun updateSubscriber(id: Long, name: String, email: String)

    suspend fun deleteSubscriber(id: Long)

    suspend fun deleAllSubscribers()

    suspend fun getAllSubscribers(): LiveData<List<SubscriberEntity>>
}