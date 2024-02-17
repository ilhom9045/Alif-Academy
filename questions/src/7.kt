/*
Палиндромное число:
Напишите программу, которая проверяет, является ли введенное число палиндромом.
* */

fun main() {
    println("Hello world!")
    val sample:String = "radarr"

    val Result = ReverseText(sample)
    print(sample==Result)

}


fun ReverseText(t:String):String{
    var tmp:String=""
    val c:Int = t.length -1
    for (i in  c downTo 0) tmp = tmp + t[i]
    return tmp
}
