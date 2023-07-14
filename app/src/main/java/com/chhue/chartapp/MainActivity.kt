package com.chhue.chartapp

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.chhue.chartapp.databinding.ActivityMainBinding
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.opencsv.CSVReader
import java.io.InputStreamReader


class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    val red = "#FFFF0000"
    val blue = "#FF0000FF"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val assetManager = this.assets
        val inputStream = assetManager.open("ncer.csv")
        val entriesRed1 = ArrayList<Entry>()
        val entriesRed2 = ArrayList<Entry>()
        val entriesRed3 = ArrayList<Entry>()
        val entriesBlue1 = ArrayList<Entry>()
        val entriesBlue2 = ArrayList<Entry>()
        val entriesBlue3 = ArrayList<Entry>()

        val reader = CSVReader(InputStreamReader(inputStream))

        val allContent = reader.readAll()
        for(content in allContent) {
            Log.i("ttt", content.toList().toString())
            var contentList = content.toList()
            entriesRed1.add(Entry(contentList[0].toFloat(),contentList[1].toFloat()))
            entriesRed2.add(Entry(contentList[0].toFloat(),contentList[2].toFloat()))
            entriesRed3.add(Entry(contentList[0].toFloat(),contentList[3].toFloat()))
            entriesBlue1.add(Entry(contentList[0].toFloat(),contentList[4].toFloat()))
            entriesBlue2.add(Entry(contentList[0].toFloat(),contentList[5].toFloat()))
            entriesBlue3.add(Entry(contentList[0].toFloat(),contentList[6].toFloat()))

        }

        setChart(entriesRed1, entriesBlue1, "Red1", "Blue1", binding.chart1, "chart1")
        setChart(entriesRed2, entriesBlue2, "Red2", "Blue2", binding.chart2, "chart2")
        setChart(entriesRed3, entriesBlue3, "Red3", "Blue3", binding.chart3, "chart3")

    }

    fun setChart(entriesR:ArrayList<Entry>, entriesB:ArrayList<Entry>, label1:String, label2:String, lineChart: LineChart, chartName:String) {

        val lineDataSetR = LineDataSet(entriesR, label1)
        lineDataSetR.lineWidth = 2f
        lineDataSetR.circleRadius = 2f
        lineDataSetR.setCircleColor(Color.parseColor(red));
        lineDataSetR.color = Color.parseColor(red);

        val lineDataSetB = LineDataSet(entriesB, label2)
        lineDataSetB.lineWidth = 2f
        lineDataSetB.circleRadius = 2f
        lineDataSetB.setCircleColor(Color.parseColor(blue));
        lineDataSetB.color = Color.parseColor(blue);

        val lineData = LineData()
        lineData.addDataSet(lineDataSetR)
        lineData.addDataSet(lineDataSetB)
        lineChart.data = lineData

        val xAxis = lineChart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.textColor = Color.BLACK
        xAxis.enableGridDashedLine(8f, 24f, 0f)

        val yLAxis = lineChart.axisLeft
        yLAxis.textColor = Color.BLACK

        val yRAxis = lineChart.axisRight
        yRAxis.setDrawLabels(false)
        yRAxis.setDrawAxisLine(false)
        yRAxis.setDrawGridLines(false)

        val description = Description()
        description.text = chartName
        lineChart.description = description

    }


}