package com.example.assessmentraven.model

data class Binance(
    val openTime: Long,
    val open: Double,
    val high: Double,
    val low: Double,
    val close: Double,
    val volume: Double,
    val closeTime: Long,
    val quoteAssetVolume: Double,
    val numberOfTrades: Int,
    val takerBuyBaseAssetVolume: Double,
    val takerBuyQuoteAssetVolume: Double,
    val ignore: Double
)

fun List<List<Any>>.toKlines(): List<Binance> {
    return map { binance ->
        Binance(
            openTime = binance[0] as Long,
            open = (binance[1] as String).toDouble(),
            high = (binance[2] as String).toDouble(),
            low = (binance[3] as String).toDouble(),
            close = (binance[4] as String).toDouble(),
            volume = (binance[5] as String).toDouble(),
            closeTime = binance[6] as Long,
            quoteAssetVolume = (binance[7] as String).toDouble(),
            numberOfTrades = binance[8] as Int,
            takerBuyBaseAssetVolume = (binance[9] as String).toDouble(),
            takerBuyQuoteAssetVolume = (binance[10] as String).toDouble(),
            ignore = (binance[11] as String).toDouble()
        )
    }
}
