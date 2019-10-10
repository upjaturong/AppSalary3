package com.example.salary2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var handler: DatabaseHelper
    var daily: RecyclerView? = null

    var date_1 = arrayOf(
        "20", "21", "22", "23", "24", "25"
    )
    var date_2 = arrayOf(
        "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"
    )
    var date_3 = arrayOf(
        "September 2019",
        "September 2019",
        "September 2019",
        "September 2019",
        "September 2019",
        "September 2019"
    )

    var namefood = arrayOf(
        "น้ำดื่ม", "อาหาร", "ค่าเฟ่", "ชานมไข่มุก", "ค่าเฟ่", "ชานมไข่มุก"
    )

    var arrImg = arrayOf<Int>(
        R.drawable.ic_lemontea,
        R.drawable.img_greentea,
        R.drawable.img_milkgreentea,
        R.drawable.pangyen,
        R.drawable.img_milkgreentea,
        R.drawable.pangyen,
        R.drawable.img_milkgreentea

    )
    var price = arrayOf(
        "฿ 10", "฿ 20", "฿ 30", "฿ 40", "฿ 30", "฿ 40"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        daily = findViewById<RecyclerView>(R.id.recyclerview)
        daily!!.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        val myAdapter = Adapter(date_1, date_2, date_3, namefood, arrImg, price, price, this)
        daily!!.adapter = myAdapter

        fab_main.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddActivity::class.java))
        }
        report.setOnClickListener {
            startActivity(Intent(this@MainActivity, FullReportActivity::class.java))
        }
        var user = " " + handler.viewUser()
        val show = findViewById<TextView>(R.id.showusername)
        show.text = user
    }
}
