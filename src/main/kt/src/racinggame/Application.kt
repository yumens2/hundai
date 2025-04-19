package racinggame

fun main() {
    Application().start()
}

class Application {
    fun start() {
        val carNames = InputView.readCarNames()
        val tryCount = InputView.readTryCount()

        val cars = Cars(carNames.map { Car(it) })
        val game = RacingGame(cars)

        println("\n실행 결과")
        repeat(tryCount) {
            game.race()
            ResultView.printRaceResult(cars)
        }

        ResultView.printWinners(cars.findWinners())
    }
}

object InputView {
    fun readCarNames(): List<String> {
        while (true) {
            try {
                println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
                val input = readln()
                return input.split(",").map { it.trim() }.also {
                    require(it.all { name -> name.length in 1..5 }) { "[ERROR] 이름은 1자 이상 5자 이하만 가능합니다." }
                }
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readTryCount(): Int {
        while (true) {
            try {
                println("시도할 회수는 몇회인가요?")
                val input = readln()
                return input.toInt().also {
                    require(it > 0) { "[ERROR] 회수는 1 이상이어야 합니다." }
                }
            } catch (e: Exception) {
                println("[ERROR] 올바른 숫자를 입력해주세요.")
            }
        }
    }
}

object ResultView {
    fun printRaceResult(cars: Cars) {
        cars.all().forEach {
            println("${it.name} : ${"-".repeat(it.position)}")
        }
        println()
    }

    fun printWinners(winners: List<Car>) {
        println("최종 우승자 : ${winners.joinToString(", ") { it.name }}")
    }
}

class RacingGame(private val cars: Cars) {
    fun race() {
        cars.moveAll()
    }
}

class Cars(private val cars: List<Car>) {
    fun moveAll() {
        cars.forEach { it.move(RandomGenerator.generate()) }
    }

    fun all(): List<Car> = cars

    fun findWinners(): List<Car> {
        val max = cars.maxOf { it.position }
        return cars.filter { it.position == max }
    }
}

class Car(val name: String, var position: Int = 0) {
    fun move(condition: Int) {
        if (condition >= 4) position++
    }
}

object RandomGenerator {
    fun generate(): Int = (0..9).random()
}
