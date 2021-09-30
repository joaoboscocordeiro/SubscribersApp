package br.com.multalpha.aplicativos.v1.subscribersapp.ui.subscriberlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import br.com.multalpha.aplicativos.v1.subscribersapp.R
import br.com.multalpha.aplicativos.v1.subscribersapp.data.AppDatabase
import br.com.multalpha.aplicativos.v1.subscribersapp.data.db.dao.SubscriberDAO
import br.com.multalpha.aplicativos.v1.subscribersapp.extension.navigateWithAnimations
import br.com.multalpha.aplicativos.v1.subscribersapp.repository.DatabaseDataSource
import br.com.multalpha.aplicativos.v1.subscribersapp.repository.SubscriberRepository
import kotlinx.android.synthetic.main.subscriber_list_fragment.*

class SubscriberListFragment : Fragment(R.layout.subscriber_list_fragment) {

    private val viewModel: SubscriberListViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val subscriberDAO: SubscriberDAO =
                    AppDatabase.getInstance(requireContext()).subscriberDAO

                val repository: SubscriberRepository = DatabaseDataSource(subscriberDAO)
                return SubscriberListViewModel(repository) as T
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModelEvents()
        configureViewListeners()
    }

    private fun observeViewModelEvents() {
        viewModel.allSubscribersEvent.observe(viewLifecycleOwner) { allSubscribers ->
            val subscriberListAdapter = SubscriberListAdapter(allSubscribers)

            recycler_subscribers.run {
                setHasFixedSize(true)
                adapter = subscriberListAdapter
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getSubscribers()
    }

    private fun configureViewListeners() {
        fab_add_subscriber.setOnClickListener {
            findNavController().navigateWithAnimations(R.id.subscriberFragment)
        }
    }
}