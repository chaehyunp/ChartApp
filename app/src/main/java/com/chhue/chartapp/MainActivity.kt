package com.chhue.chartapp

import android.content.res.AssetManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.chhue.chartapp.databinding.ActivityMainBinding
import com.opencsv.CSVReader
import com.opencsv.exceptions.CsvException
import java.io.IOException
import java.io.InputStreamReader


class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }

    @Throws(IOException::class, CsvException::class)
    private fun loadData() {
        val assetManager: AssetManager = this.getAssets()
        val inputStream = assetManager.open("ncer.csv")
        val csvReader = CSVReader(InputStreamReader(inputStream, "EUC-KR"))
        val allContent = csvReader.readAll() as List<Array<String>>
        for (content in allContent) {
            val sb = StringBuilder("")
            Log.d(
                "csv",
                content[19] + " 병원명: " + content[21] + " X: " + content[26] + " Y: " + content[27]
            )
        }
    }
}