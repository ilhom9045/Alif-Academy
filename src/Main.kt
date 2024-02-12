

fun main() {
    val sampleObject = Sample.newInstance()
    sampleObject.counder++
    val sampleObject2 = Sample.newInstance()
    sampleObject2.counder++
    println(sampleObject2.counder)
    println(sampleObject.counder)
    print("Hello World!")
}

class Sample private constructor() {

    var counder = 0

    companion object {

        private var sample: Sample? = null

        fun newInstance(): Sample {
            return sample ?: Sample().apply {
                sample = this
            }
        }
    }

}

object Sample2 {

    var counder = 0
}

fun String.name() {

}