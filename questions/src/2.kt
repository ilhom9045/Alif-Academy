/*
Определение среднего значения:
Напишите программу, которая находит среднее значение элементов в массиве.
* */

fun main() {
    val array = intArrayOf(2,4,5,6,5,7)
    var a=0
    for (i in array){
       a=a+i

    }

    println(a/array.size)
}