package cinema

fun main() {
    println("Cinema:")
    //print the horizontal index
    println("  1 2 3 4 5 6 7 8")
    val seatsCount: Int = 8
    val rowCount: Int = 7
    var seatsGraphic: String =""

    //Create the seat line
    repeat(seatsCount) {
        seatsGraphic += "S "
    }
    //Layout the Cinema hall
    repeat(rowCount) {
        println("${it + 1} $seatsGraphic" )
    }
}
