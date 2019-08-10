package io.github.wellingtoncosta.cursoandroidcongressodeti.domain.extensions.executors

import java.util.concurrent.Callable
import java.util.concurrent.Executors.newSingleThreadExecutor

fun <T> runAsync(block: () -> T): T =
    newSingleThreadExecutor().submit(Callable<T> { block() }).get()

fun doInBackground(block: () -> Unit): Unit =
    newSingleThreadExecutor().submit { block() }.let { Unit }