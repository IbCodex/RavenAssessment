package com.example.assessmentraven

import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.assessmentraven.databinding.FragmentChartsBinding
import com.github.mikephil.charting.charts.CandleStickChart
import com.github.mikephil.charting.data.*


class ChartsFragment : Fragment() {
    private var _binding: FragmentChartsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentChartsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val candleStickChart: CandleStickChart = binding.chart
        candleStickChart.isHighlightPerDragEnabled = true

        candleStickChart.setDrawBorders(true)

        candleStickChart.setBorderColor(resources.getColor(R.color.colorLightGray))

        val yAxis = candleStickChart.axisLeft
        val rightAxis = candleStickChart.axisRight
        yAxis.setDrawGridLines(false)
        rightAxis.setDrawGridLines(false)
        candleStickChart.requestDisallowInterceptTouchEvent(true)

        val xAxis = candleStickChart.xAxis

        xAxis.setDrawGridLines(false) // disable x axis grid lines

        xAxis.setDrawLabels(false)
        rightAxis.textColor = Color.WHITE
        yAxis.setDrawLabels(false)
        xAxis.granularity = 1f
        xAxis.isGranularityEnabled = true
        xAxis.setAvoidFirstLastClipping(true)

        val l = candleStickChart.legend
        l.isEnabled = false

        // Sample data for demonstration
        val yValsCandleStick = ArrayList<CandleEntry>()
        yValsCandleStick.add(CandleEntry(0f, 225.0f, 219.84f, 224.94f, 221.07f))
        yValsCandleStick.add(CandleEntry(1f, 228.35f, 222.57f, 223.52f, 226.41f))
        yValsCandleStick.add(CandleEntry(2f, 226.84f,  222.52f, 225.75f, 223.84f))
        yValsCandleStick.add(CandleEntry(3f, 222.95f, 217.27f, 222.15f, 217.88f))
        yValsCandleStick.add(CandleEntry(4f, 223.45f, 219.32f, 220.18f, 221.56f))
        yValsCandleStick.add(CandleEntry(5f, 222.57f, 221.12f, 223.65f, 222.98f))
        yValsCandleStick.add(CandleEntry(6f, 224.32f, 221.76f, 222.45f, 224.18f))
        yValsCandleStick.add(CandleEntry(7f, 223.97f, 220.65f, 223.18f, 221.76f))
        yValsCandleStick.add(CandleEntry(8f, 222.87f, 221.34f, 222.65f, 222.18f))
        yValsCandleStick.add(CandleEntry(9f, 221.56f, 218.98f, 220.45f, 219.87f))


        val set1 = CandleDataSet(yValsCandleStick, "DataSet 1")
        set1.color = Color.rgb(80, 80, 80)
        set1.shadowColor = resources.getColor(R.color.colorLightGrayMore)
        set1.decreasingColor = resources.getColor(R.color.colorRed)
        set1.decreasingPaintStyle = Paint.Style.FILL
        set1.increasingColor = resources.getColor(R.color.green)
        set1.increasingPaintStyle = Paint.Style.FILL
        set1.neutralColor = Color.LTGRAY
        set1.setDrawValues(false)

        // create a data object with the datasets
        val data = CandleData(set1)

        // set data
        candleStickChart.data = data
        candleStickChart.invalidate()

        xAxis.granularity = 1f
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


