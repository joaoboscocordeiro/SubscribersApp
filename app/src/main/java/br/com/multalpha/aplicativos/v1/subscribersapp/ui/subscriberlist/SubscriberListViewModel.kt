package br.com.multalpha.aplicativos.v1.subscribersapp.ui.subscriberlist

import androidx.lifecycle.ViewModel
import br.com.multalpha.aplicativos.v1.subscribersapp.repository.SubscriberRepository

class SubscriberListViewModel(
    private val repository: SubscriberRepository
) : ViewModel() {

    val allSubscribersEvent = repository.getAllSubscribers()
}