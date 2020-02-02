package com.navin.melalwallet.utils

class UtilityTest {


    fun getZoj(i: Int): Boolean {
        return if (i % 2 == 0) {
            true
        } else {
            false
        }
    }

    companion object {


        fun getMin(a: Int, b: Int): Int {

            return if (a > b) {
                b
            } else {
                a
            }
        }
    }

}
