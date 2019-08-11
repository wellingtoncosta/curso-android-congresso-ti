package io.github.wellingtoncosta.cursoandroidcongressodeti.resources.extension

import java.util.concurrent.Executors.newSingleThreadExecutor

fun doInBackground(block: () -> Unit): Unit =
    newSingleThreadExecutor().submit { block() }.let { Unit }
