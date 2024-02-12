// 2 - ГРУППА
// Это наш Базовый Интерфейс который мы используем
interface Transport<T> {
    var brand: T
    var color: T
    fun exat()
}

fun main() {
    val car = Car("BMW", "SIYOX")
    println(car.brand)
    println(car.color)
    car.signal()
    car.refuel()
    car.exat()
    println("")
    val bicycle = Bicycle("Bicycle", "Black")
    println(bicycle.brand)
    println(bicycle.color)
    bicycle.zvukVelosiped()
    bicycle.exat()
    println("")
    val truck = Truck("kamaz", "Red")
    println(truck.brand)
    println(truck.color)
    truck.gruuzTruck()
    truck.horn()
    truck.exat()
    println("")
    val drone = Drone("Mfavik M200", "Blue")
    println(drone.brand)
    println(drone.color)
    drone.fly()
    drone.horn()
    drone.exat()
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
    override var color: String
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