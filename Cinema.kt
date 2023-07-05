package cinema
var rowsCount: Int = 0
var seatsInRow: Int = 0

fun createCinemaMatrix ():MutableList<MutableList<String>>
{

    val cinemaIndicatorLine = MutableList(seatsInRow+1) {" "}
    val cinemaMatrix = mutableListOf<MutableList<String>>()

    for (i in 1..seatsInRow) { cinemaIndicatorLine[i]=i.toString();}
    cinemaMatrix.add(cinemaIndicatorLine)

    for(i in 1 .. rowsCount)
    {
        val rowOfSeats = MutableList(seatsInRow){"S"}
        rowOfSeats.add(0,i.toString())
        cinemaMatrix.add(rowOfSeats)
    }

    return cinemaMatrix
}

fun printCinemaMatrix (cinemaMatrix: MutableList<MutableList<String>>)
{
    println("\nCinema:")
    for (i in cinemaMatrix.indices)
    {
        for (j in cinemaMatrix[i].indices)
        {
            print(" "+cinemaMatrix[i][j])
        }
       print("\n")
    }

}


fun bookSeat (cinemaMatrix: MutableList<MutableList<String>>):MutableList<MutableList<String>>
{
    println("\nEnter a row number:")
    val rowNumber = readln().toInt()
    println("\nEnter a seat number in that row:")
    val seatNumber = readln().toInt()

    val ticketPrice = if (rowsCount * seatsInRow  >= 60 && rowNumber > rowsCount/2) { 8 } else  { 10 }

    println("Ticket price: \$"+ticketPrice)

    cinemaMatrix[rowNumber][seatNumber]="B"

    return cinemaMatrix
}

fun main() {

    println("Enter the number of rows:")
    rowsCount = readln().toInt()
    println("Enter the number of seats in each row:")
    seatsInRow = readln().toInt()

    var cinemaMatrix: MutableList<MutableList<String>> = createCinemaMatrix()

    while (true)
    {   println("\n1. Show the seats\n2. Buy a ticket \n0. Exit")
        when (readln().toInt())
        {
            1 -> printCinemaMatrix(cinemaMatrix)
            2 -> cinemaMatrix = bookSeat(cinemaMatrix)
            else -> break
        }
    }

}
