package io.github.wellingtoncosta.cursoandroidcongressodeti

import android.app.Application
import com.github.kittinunf.fuel.core.FuelManager
import io.github.wellingtoncosta.cursoandroidcongressodeti.BuildConfig.API_URL

class CursoAndroidApp : Application() {

    override fun onCreate() {
        super.onCreate()

        FuelManager.instance.basePath = API_URL
    }

}
