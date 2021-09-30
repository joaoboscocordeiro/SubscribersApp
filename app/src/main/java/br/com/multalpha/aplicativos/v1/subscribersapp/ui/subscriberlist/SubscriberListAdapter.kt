package br.com.multalpha.aplicativos.v1.subscribersapp.ui.subscriberlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.multalpha.aplicativos.v1.subscribersapp.R
import br.com.multalpha.aplicativos.v1.subscribersapp.data.db.entity.SubscriberEntity
import kotlinx.android.synthetic.main.subscriber_item.view.*

/**
 * Created by João Bosco on 30/09/2021.
 * e-mail - Support: ti.junior@gmail.com
 */

class SubscriberListAdapter(
    private val subscribers: List<SubscriberEntity>
) : RecyclerView.Adapter<SubscriberListAdapter.SubscriberListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriberListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.subscriber_item, parent, false)

        return SubscriberListViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubscriberListViewHolder, position: Int) {
        holder.bindView(subscribers[position])
    }

    override fun getItemCount(): Int = subscribers.size

    class SubscriberListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val name: TextView = itemView.text_subscriber_name
        private val email: TextView = itemView.text_subscriber_email

        fun bindView(subscriber: SubscriberEntity) {
            name.text = subscriber.name
            email.text = subscriber.email
        }
    }
}