package com.example.culturle

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 * CI TEST
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    /**
     * An example Unit Test which always succeeds
     */
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    /**
     * A unit test which checks that gamesPlayed has not exceeded gamesWon, and
     * checks that bestStreak does not exceed winStreak.
     */
//    @Test
//    fun logicalStats() {
//        val statsInstance = Stats()
//        assertTrue(statsInstance.getStat("gamesPlayed") >= statsInstance.getStat("gamesWon"))
//        assertTrue(statsInstance.getStat("winStreak") <= statsInstance.getStat("bestStreak"))
//    }

//    @Test
//    fun correctAnswerPresentInOptions() {
//        val dailyInstance = Daily()
//        assertTrue(XXXXArray.contains(todaysCountry))
//    }
}