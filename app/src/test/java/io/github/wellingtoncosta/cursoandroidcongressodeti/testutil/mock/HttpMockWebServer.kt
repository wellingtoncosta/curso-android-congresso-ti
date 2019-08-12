package io.github.wellingtoncosta.cursoandroidcongressodeti.testutil.mock

import com.github.kittinunf.fuel.core.FuelManager
import okhttp3.mockwebserver.MockWebServer

fun startHttpServer() = MockWebServer().apply {
    FuelManager.instance.basePath = url("/").toString()
}
