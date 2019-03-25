package com.btc.calc.resources

import io.kotlintest.data.forall
import io.kotlintest.properties.assertAll
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row
import javax.ws.rs.WebApplicationException


class CalcTest : StringSpec({

    val resource = Calc()

    "Add a and b" {
        assertAll({ a: Double, b: Double ->
            resource.add(a, b) shouldBe a + b
        })
    }

    "Subtract a and b" {
        assertAll({ a: Double, b: Double ->
            resource.subtract(a, b) shouldBe a - b
        })
    }

    "Multiply a and b" {
        assertAll({ a: Double, b: Double ->
            resource.multiply(a, b) shouldBe a * b
        })
    }

    "Reciprocal of a" {
        assertAll{ a:Double ->
            if (a != .0) {
                resource.reciprocal(a) shouldBe 1 / a
            }
        }
    }


    "Reciprocal of 0 should return an Error" {
        val exception = shouldThrow<WebApplicationException> {
            resource.reciprocal(.0)
        }
        exception.message shouldBe "Zero does not have a reciprocal because no number multiplied by 0 equals 1"
        exception.response.status shouldBe 422
    }
})