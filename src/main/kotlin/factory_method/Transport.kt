package factory_method

interface Carry {
    fun receive();
    fun delivery();
}

class CarTransport : Carry {
    override fun receive() {
        println("Car received supplies")
        delivery()
    }

    override fun delivery() {
        println("Supplies delivered by car")
    }
}

class ShipTransport : Carry {
    override fun receive() {
        println("Ship received supplies")
        delivery()
    }

    override fun delivery() {
        println("Supplies delivered by ship")
    }
}

abstract class Vehicle {

    fun setVehicle() {
        val vehicle: Carry = createVehicle()
        vehicle.receive()
    }

    abstract fun createVehicle(): Carry
}

class Car : Vehicle() {
    override fun createVehicle(): Carry {
        return CarTransport()
    }
}

class Ship : Vehicle() {
    override fun createVehicle(): Carry {
        return ShipTransport()
    }
}

lateinit var vehicle: Vehicle

fun main() {
    configure();
    runBusinessLogic()
}

private fun runBusinessLogic() {
    vehicle.setVehicle()
}

private fun configure() {
    vehicle = Car()
    if (vehicle is Car) {
        println("Car instance")
    } else if (vehicle is Ship) {
        println("Vehicle instance")
    }
}