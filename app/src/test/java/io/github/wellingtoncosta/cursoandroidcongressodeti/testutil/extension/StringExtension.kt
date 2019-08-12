package io.github.wellingtoncosta.cursoandroidcongressodeti.testutil.extension

fun String.asJson(): String = javaClass.getResource(this)?.readBytes()?.let { String(it) }.toString()