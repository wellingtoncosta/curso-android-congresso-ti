package io.github.wellingtoncosta.cursoandroidcongressodeti.testutil

import java.util.concurrent.AbstractExecutorService
import java.util.concurrent.TimeUnit

class CurrentThreadExecutorService : AbstractExecutorService() {

    @Volatile private var terminated: Boolean = false

    override fun isTerminated() = terminated

    override fun shutdown() { terminated = true }

    override fun shutdownNow() = emptyList<Runnable>()

    override fun isShutdown() = terminated

    override fun awaitTermination(timeout: Long, timeunit: TimeUnit): Boolean {
        shutdown()

        return terminated
    }

    override fun execute(runnable: Runnable) { runnable.run() }

}