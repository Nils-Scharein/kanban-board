package dev.nils.backend.util

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class FractionalIndexerTest {

    // Testvektoren aus https://observablehq.com/@dgreensp/implementing-fractional-indexing
    // '' = leerer String, NULL = keine Grenze auf dieser Seite
    @ParameterizedTest(name = "({0}, {1}) -> {2}")
    @CsvSource(
        nullValues = ["NULL"],
        value = [
            "'',    NULL,     V",
            "V,     NULL,     l",
            "l,     NULL,     t",
            "t,     NULL,     x",
            "x,     NULL,     z",
            "z,     NULL,     zV",
            "zV,    NULL,     zl",
            "zl,    NULL,     zt",
            "zt,    NULL,     zx",
            "zx,    NULL,     zz",
            "zz,    NULL,     zzV",
            "1,     2,        1V",
            "001,   001002,   001001",
            "001,   001001,   001000V",
            "'',    V,        G",
            "'',    G,        8",
            "'',    8,        4",
            "'',    4,        2",
            "'',    2,        1",
            "'',    1,        0V",
            "0V,    1,        0l",
            "'',    0G,       08",
            "'',    08,       04",
            "'',    02,       01",
            "'',    01,       00V",
            "4zz,   5,        4zzV",
        ],
    )
    fun returnsKeyBetween(a: String, b: String?, expected: String) {
        assertEquals(expected, FractionalIndexer.generateKeyBetween(a, b))
    }

    @ParameterizedTest(name = "({0}, {1}) throws IllegalArgumentException")
    @CsvSource(
        value = [
            "2,     1",
            "'',    ''",
            "0,     1",
            "1,     10",
            "11,    1",
        ],
    )
    fun rejectsInvalidInput(a: String, b: String?) {
        assertThrows<IllegalArgumentException> {
            FractionalIndexer.generateKeyBetween(a, b)
        }
    }
}
