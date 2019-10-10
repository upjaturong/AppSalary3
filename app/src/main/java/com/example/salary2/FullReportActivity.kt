package com.example.salary2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlinx.android.synthetic.main.activity_full_report.*

class FullReportActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_report)
        setUpPieChartData()

    }
    private fun setUpPieChartData() {
        val yVals = ArrayList<PieEntry>()
        yVals.add(PieEntry(30f,"48%"))
        yVals.add(PieEntry(2f,"10%"))
        yVals.add(PieEntry(4f,"15%"))
        yVals.add(PieEntry(22f,"30%"))
        yVals.add(PieEntry(12.5f,"20%"))
        yVals.add(PieEntry(22f,"30%"))
        yVals.add(PieEntry(12.5f,"20%"))

        val dataSet = PieDataSet(yVals, "")
        dataSet.valueTextSize=0f
        val colors = java.util.ArrayList<Int>()
        colors.add(Color.GRAY)
        colors.add(Color.BLUE)
        colors.add(Color.RED)
        colors.add(Color.GREEN)
        colors.add(Color.MAGENTA)
        colors.add(Color.CYAN)
        colors.add(Color.DKGRAY)
        dataSet.setColors(colors)


        val data = PieData(dataSet)
        pieChart.data = data
        pieChart.centerTextRadiusPercent = 0f
        pieChart.isDrawHoleEnabled = false
        pieChart.legend.isEnabled = false
        pieChart.description.isEnabled = false
    }
}
