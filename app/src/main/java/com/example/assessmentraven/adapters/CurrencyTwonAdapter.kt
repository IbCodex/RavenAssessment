package com.example.assessmentraven.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assessmentraven.R
import com.example.assessmentraven.databinding.ListItemsBinding
import com.example.assessmentraven.databinding.ListedItemsBinding
import com.example.assessmentraven.model.DummyListItem
import com.example.assessmentraven.model.DummyListedItem

class CurrencyTwonAdapter(
    private val onClick:(item: DummyListedItem) -> Unit
): RecyclerView.Adapter<CurrencyTwonAdapter.DataBundleItemViewHolder>() {
    private var dataBundleItemList: ArrayList<DummyListedItem> = arrayListOf()
    private var selectedPos = -1

     inner class DataBundleItemViewHolder(val binding: ListedItemsBinding): RecyclerView.ViewHolder(binding.root) {

         var constraintLayout = binding.constraint

         fun bind(dummyListedItem: DummyListedItem) {
             binding.pricePush.text = dummyListedItem.price.toString()
             binding.amountPush.text =  dummyListedItem.amount.toString()
             binding.buyNowFetch.text = dummyListedItem.total.toString()



             binding.root.setOnClickListener {
                 if (absoluteAdapterPosition == RecyclerView.NO_POSITION) return@setOnClickListener
                 notifyItemChanged(selectedPos)
                 selectedPos = absoluteAdapterPosition
                 notifyItemChanged(selectedPos)
             }
             binding.constraint.setOnClickListener { onClick(dummyListedItem) }
         }
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBundleItemViewHolder {
          val inflater = ListedItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
          return DataBundleItemViewHolder(inflater)
     }

     override fun onBindViewHolder(holder: DataBundleItemViewHolder, @SuppressLint("RecyclerView") position: Int) {
          holder.bind(dataBundleItemList[position])
         holder.itemView.isSelected = selectedPos == position
         holder.itemView.setBackgroundResource(if (selectedPos ==position) R.drawable.green_stroke_128dp_corners else R.drawable.grey_stroke_128dp_corners)

     }

     override fun getItemCount(): Int = dataBundleItemList.size
     fun submitList (list: ArrayList<DummyListedItem>){
         dataBundleItemList = list
         notifyDataSetChanged()
     }

    companion object {
        private const val TAG = "AirtimeAdapter"
    }
}