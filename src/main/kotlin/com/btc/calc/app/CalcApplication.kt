package com.btc.calc.app

import com.btc.calc.resources.Calc
import io.dropwizard.Application
import io.dropwizard.Configuration
import io.dropwizard.setup.Environment

fun main(args : Array<String>) {
    CalcApplication().run(*args)
}


class CalcApplication() : Application<CalcConfig>() {


    override fun run(configuration: CalcConfig, environment: Environment?) {
        println("Running ${configuration.name}")

        environment?.jersey()?.register(Calc())
    }

}

class CalcConfig(val name: String = "unknown") : Configuration()
