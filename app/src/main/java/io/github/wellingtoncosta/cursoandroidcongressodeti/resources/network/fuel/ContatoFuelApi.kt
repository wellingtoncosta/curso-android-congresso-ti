package io.github.wellingtoncosta.cursoandroidcongressodeti.resources.network.fuel

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.gson.responseObject
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.exception.NetworkException
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.network.ContatoApi
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.network.entity.ContatoResponse

class ContatoFuelApi : ContatoApi {

    override fun listarTodos() = Fuel.get("/contacts")
        .responseObject<List<ContatoResponse>>().let {
            when(it.second.statusCode) {
                200, 304 -> it.third.get()
                else -> throw NetworkException()
            }
        }

    override fun buscarPorId(contatoId: Int) = Fuel.get("/contacts/$contatoId")
        .responseObject<ContatoResponse>().let {
            when(it.second.statusCode) {
                200, 304 -> it.third.get()
                404 -> null
                else -> throw NetworkException()
            }
        }

}
