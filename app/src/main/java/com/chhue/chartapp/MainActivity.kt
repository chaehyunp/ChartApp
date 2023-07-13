package com.chhue.chartapp

import android.R
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chhue.chartapp.databinding.ActivityMainBinding
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets


class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val chart = binding.chart
        val entriesList = getItemList()
        showGraph(chart, entriesList)
    }

    @Throws(IOException::class)
    fun getItemList(): List<Item> {
        val `is` = InputStreamReader(assets.open("ncer.csv"))
        val reader = BufferedReader(`is`)
        var line = ""
        val itemList: MutableList<Item> = mutableListOf()
        while (reader.readLine().also { line = it } != null) {
            val tokens = line.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val item = Item()
            item.setTime(tokens[0].toDouble())
            item.setRed1(tokens[1].toDouble())
            item.setRed2(tokens[2].toDouble())
            item.setRed3(tokens[3].toDouble())
            item.setBlue1(tokens[4].toDouble())
            item.setBlue2(tokens[5].toDouble())
            item.setBlue3(tokens[6].toDouble())
            itemList.add(item) // 반환할 리스트에 파싱된 행 데이터 저장
        }
        reader.close()
        `is`.close()
        return itemList
    }

    private fun showGraph(chart:LineChart, entriesList:List<Item>) {
        val dataSets = mutableListOf<ILineDataSet>()

        // 빨간색(Red) 팀 데이터 설정
        val redEntries = entriesList[0]
        val redDataSet = LineDataSet(redEntries, "Red Team")
        redDataSet.color = Color.RED
        dataSets.add(redDataSet)

        // 파란색(Blue) 팀 데이터 설정
        val blueEntries = entriesList[1]
        val blueDataSet = LineDataSet(blueEntries, "Blue Team")
        blueDataSet.color = Color.BLUE
        dataSets.add(blueDataSet)

        val lineData = LineData(dataSets)

        chart.data = lineData
        chart.invalidate()
    }


}