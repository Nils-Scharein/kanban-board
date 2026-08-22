package dev.nils.backend.util

import kotlin.math.roundToInt

object FractionalIndexer {
    const val indexDigits: String = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"

    // Source: https://observablehq.com/@dgreensp/implementing-fractional-indexing
    fun generateKeyBetween(a: String, b: String?, digits: String = indexDigits): String {
        val zero = digits[0]

        if(b != null && a >= b) {
            throw IllegalArgumentException("Start key must be less than end key")
        }
        if(a.lastOrNull() == zero || (b != null && b.lastOrNull() == zero)) {
            throw IllegalArgumentException("trailing zeros are not allowed")
        }

        if (b != null) {
            var n = 0
            while ((a.getOrNull(n) ?: zero) == b.getOrNull(n)) {
                n++
            }
            if (n > 0) {
                return b.substring(0, n) + generateKeyBetween(a.drop(n), b.drop(n))
            }
        }
        val digitA = if (a.isNotEmpty()) digits.indexOf(a[0]) else 0
        val digitB = if (!b.isNullOrEmpty()) digits.indexOf(b[0]) else digits.length

        if (digitB - digitA > 1) {
            val midDigit = (0.5 * (digitA + digitB)).roundToInt()
            return digits[midDigit].toString()
        } else {
            // first digits are consecutive
            if (b != null && b.length > 1) {
                return b.take(1)
            } else {
                // `b` is null or has length 1 (a single digit).
                // the first digit of `a` is the previous digit to `b`,
                // or 9 if `b` is null.
                // given, for example, midpoint('49', '5'), return
                // '4' + midpoint('9', null), which will become
                // '4' + '9' + midpoint('', null), which is '495'
                return digits[digitA].toString() + generateKeyBetween(a.drop(1), null, digits)
            }
        }
    }
}
