package br.com.multalpha.aplicativos.v1.subscribersapp.repository

import androidx.lifecycle.LiveData
import br.com.multalpha.aplicativos.v1.subscribersapp.data.dao.SubscriberDAO
import br.com.multalpha.aplicativos.v1.subscribersapp.data.entity.SubscriberEntity

/**
 * Created by João Bosco on 29/09/2021.
 * e-mail - Support: ti.junior@gmail.com
 */

class DatabaseDataSource(
    private val subscriberDAO: SubscriberDAO
) : SubscriberRepository {

    override suspend fun insertSubscriber(name: String, email: String): Long {
        val subscriber = SubscriberEntity(
            name = name,
            email = email
        )
        return subscriberDAO.insert(subscriber)
    }

    override suspend fun updateSubscriber(id: Long, name: String, email: String) {
        val subscriber = SubscriberEntity(
            id = id,
            name = name,
            email = email
        )
        subscriberDAO.update(subscriber)
    }

    override suspend fun deleteSubscriber(id: Long) {

        subscriberDAO.delete(id)
    }

    override suspend fun deleAllSubscribers() {
        subscriberDAO.deleteAll()
    }

    override suspend fun getAllSubscribers(): LiveData<List<SubscriberEntity>> {
        return subscriberDAO.getAll()
    }
}