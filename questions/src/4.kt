/*
Поиск пропущенного числа:
Дан массив из N-1 уникальных чисел от 1 до N.
Напишите программу для поиска пропущенного числа.
* */

fun main() {
    val test1 = arrayOf(1,2,4,5) // 3
    val test2 = arrayOf(1,2,3,4,5,7) // 6
    val test3 = arrayOf(1,3,4,5,6,7) // 2
    пропушенное_число(test1)
    пропушенное_число(test2)
    пропушенное_число(test3)
}

fun пропушенное_число(array: Array<Int>):Int{
    array.forEachIndexed { index, i ->
        if((index + 1) != array.size){
            val nextValue = array[index+1]
            if ((i+1) != nextValue){
                println(i+1)
                return@forEachIndexed
            }
        }
    }
    return 0
}