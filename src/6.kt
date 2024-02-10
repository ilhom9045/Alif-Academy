/*
Сложение двух чисел:
Напишите программу, которая принимает на вход два числа и выводит их сумму.
**/

fun main() {
    val a = getNumber("input a")
    val b = getNumber("input b")
    println(a + b)

}

fun getNumber(text: String): Int {
    println(text)
    val a = readLine()?.toIntOrNull()
    println(a)
    if (a == null){
        return getNumber(text)
    }
    return a!!
}