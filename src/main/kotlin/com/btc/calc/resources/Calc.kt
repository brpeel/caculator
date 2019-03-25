package com.btc.calc.resources

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.QueryParam
import javax.ws.rs.WebApplicationException
import javax.ws.rs.core.Response

@Path("/")
class Calc {
    @Path("/add")
    @GET
    fun add(@QueryParam("a") a: Double, @QueryParam("b") b: Double): Double {
        return a + b
    }

    @Path("/subtract")
    @GET
    fun subtract(@QueryParam("a") a: Double, @QueryParam("b") b: Double): Double {
        return a - b
    }

    @Path("/multiply")
    @GET
    fun multiply(@QueryParam("a") a: Double, @QueryParam("b") b: Double): Double {
        return a * b
    }

    @Path("/divide")
    @GET
    fun divide(@QueryParam("a") a: Double, @QueryParam("b") b: Double): Double {
        if (b == 0.0) {
            throw WebApplicationException("Cannot divide by Zero")
        }
        return a / b
    }

    @Path("/reciprocal")
    @GET
    fun reciprocal(@QueryParam("a") a: Double) : Double {
        if (a == .0){
            throw WebApplicationException("Zero does not have a reciprocal because no number multiplied by 0 equals 1", 422)
        }

        return 1 / a
    }
}