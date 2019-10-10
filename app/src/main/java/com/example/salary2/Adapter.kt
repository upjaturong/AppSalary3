package com.example.salary2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.daily.view.*

class Adapter (
    var Date_1 :Array<String>,
    var Date_2 :Array<String>,
    var Date_3 :Array<String>,
   var Namefoods :Array<String>,
    var Imgfood : Array<Int>,
    var Price : Array<String>,
    var Price_total : Array<String>,
    var context: Context
) : RecyclerView.Adapter<Adapter.ViewHolderl>()  {

    class ViewHolderl(view: View): RecyclerView.ViewHolder(view) {
        var date_1 = view.date_1
        var date_2 = view.date_2
        var date_3 = view.date_3
        var namefoods = view.namefoods
        var imagefood = view.img
        var price = view.price
        var price_total = view.price_total
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderl {
        var view = LayoutInflater.from(context).inflate(R.layout.daily,parent,false)
        return ViewHolderl(view)
    }
    override fun getItemCount(): Int {
        return Namefoods.size
    }
    override fun onBindViewHolder(holder: ViewHolderl, position: Int) {
        holder.namefoods.text = Namefoods[position]
        holder.price.text = Price[position]
        holder.price_total.text= Price_total[position]
        holder.imagefood?.setBackgroundResource(Imgfood[position])
        holder.date_1.text = Date_1[position]
        holder.date_2.text = Date_2[position]
        holder.date_3.text = Date_3[position]
    }

}