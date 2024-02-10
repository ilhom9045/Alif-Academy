/*
Лучшее время для покупки и продажи акций
Вам дан массив prices где prices[i] это цена данной акции на i день.

Вы хотите максимизировать свою прибыль,
выбрав один день для покупки одной акции и выбрав
другой день в будущем для продажи этой акции.

Верните максимальную прибыль, которую вы можете получить от этой сделки .
Если вы не можете получить никакой прибыли, верните 0.
* */

fun main() {
    val pricesTest1 = intArrayOf(7, 1, 5, 3, 6, 4) // 5
    val pricesTest2 = intArrayOf(7, 6, 4, 3, 1) //0
    val pricesTest3 = intArrayOf(7, 1, 5, 3, 6, 4,7) //6
    println(maxProfit(pricesTest1))
    println(maxProfit(pricesTest2))
    println(maxProfit(pricesTest3))
}

fun maxProfit(prices: IntArray): Int {
    var min =prices[0]
    var max=0
    var index =0

    for (i in prices.indices) {
        if (prices[i] < min) {
            min = prices[i]
            index = i
        }
    }

    if (index==prices.size-1){
        return 0
    }

    max=min
        for (i in index..<prices.size){
            if (prices[i]>max){
                max=prices[i]
            }
        }
    return max-min


}


