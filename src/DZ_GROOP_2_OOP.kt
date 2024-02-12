// 2 - ГРУППА
// Это наш Базовый Интерфейс который мы используем
interface Transport<T> {
    var brand: T
    var color: T
    fun exat()
}
class Bicycle(
    override var brand: String,
    override var color: String
) : Transport<String> {
    fun zvukVelosiped() {
        println("Звук велосипеда")
    }

    override fun exat() {
        println("Катится")
    }
}

// Создаём Класс Машина
class Car(
    override var brand: String,
    override var color: String
) : Transport<String> {
    fun signal() {
        println("Сигнал")
    }

    fun refuel() {
        println("Заправляется")
    }

    override fun exat() {
        println("Ехать")
    }
}

// Создаём Класс Грузовик
class Truck(
    override var brand: String,
    override var color: String,
    var goods: Int
) : Transport<String> {
    fun horn() {
        println("Гудок")
    }

    fun gruuzTruck() {
        println("Перевозит Груз")
    }

    override fun exat() {
        println("Exaт")
    }
}

// Создаём Класс Дрон
class Drone(
    override var brand: String,
    override var color: String
) : Transport<String> {
    fun fly() {
        println("Летит")
    }

    fun horn() {
        println("Звучит")
    }

    override fun exat() {
        println("Дрон летит")
    }
}