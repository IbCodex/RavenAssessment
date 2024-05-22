package com.example.assessmentraven.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assessmentraven.R
import com.example.assessmentraven.databinding.ListItemsBinding
import com.example.assessmentraven.model.DummyListItem

class CurrencyAdapter(
    private val onClick:(item: DummyListItem) -> Unit
): RecyclerView.Adapter<CurrencyAdapter.DataBundleItemViewHolder>() {
    private var dataBundleItemList: ArrayList<DummyListItem> = arrayListOf()
    private var selectedPos = -1

     inner class DataBundleItemViewHolder(val binding: ListItemsBinding): RecyclerView.ViewHolder(binding.root) {

         var constraintLayout = binding.constraint

         fun bind(dummyListItem: DummyListItem) {
             binding.priceFetch.text = dummyListItem.price.toString()
             binding.amountFetch.text =  dummyListItem.amount.toString()
             binding.buyNow.text = dummyListItem.total.toString()



             binding.root.setOnClickListener {
                 if (absoluteAdapterPosition == RecyclerView.NO_POSITION) return@setOnClickListener
                 notifyItemChanged(selectedPos)
                 selectedPos = absoluteAdapterPosition
                 notifyItemChanged(selectedPos)
             }
             binding.constraint.setOnClickListener { onClick(dummyListItem) }
         }
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBundleItemViewHolder {
          val inflater = ListItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
          return DataBundleItemViewHolder(inflater)
     }

     override fun onBindViewHolder(holder: DataBundleItemViewHolder, @SuppressLint("RecyclerView") position: Int) {
          holder.bind(dataBundleItemList[position])
         holder.itemView.isSelected = selectedPos == position
         holder.itemView.setBackgroundResource(if (selectedPos ==position) R.drawable.green_stroke_128dp_corners else R.drawable.grey_stroke_128dp_corners)

     }

     override fun getItemCount(): Int = dataBundleItemList.size
     fun submitList (list: ArrayList<DummyListItem>){
         dataBundleItemList = list
         notifyDataSetChanged()
     }

    companion object {
        private const val TAG = "AirtimeAdapter"
    }
}