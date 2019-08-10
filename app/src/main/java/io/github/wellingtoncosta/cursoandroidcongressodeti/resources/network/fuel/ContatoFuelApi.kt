package io.github.wellingtoncosta.cursoandroidcongressodeti.resources.network.fuel

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.gson.responseObject
import com.github.kittinunf.fuel.httpGet
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.exception.NetworkException
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.network.ContatoApi
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.network.entity.ContatoResponse

class ContatoFuelApi : ContatoApi {

    override fun listarTodos(): List<ContatoResponse> {
        val (_, response, result) = "/contacts".httpGet().responseObject<List<ContatoResponse>>()

        return when(response.statusCode) {
            200, 304 -> result.get()
            else -> throw NetworkException()
        }
    }

    override fun buscarPorId(contatoId: Int): ContatoResponse? {
        val (_, response, result) = "/contacts/$contatoId".httpGet().responseObject<ContatoResponse>()

        return when(response.statusCode) {
            200, 304 -> result.get()
            404 -> null
            else -> throw NetworkException()
        }
    }

}
