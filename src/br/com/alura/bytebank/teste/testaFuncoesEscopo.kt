package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Endereco

fun testaFuncoesEscopo() {
    // - apply and also return the context object
    // - let, run, and with return the lambda result

    run {
        println("executando o run sem extensão")
    }

    val endereco = Endereco()
        .also { println("gerando endereço:") }
        .apply {
            logradouro = "rua rui barbosa"
            numero = 3185
        }
    with(endereco) {
        "$logradouro, $numero".toUpperCase()
    }.let(::println)

    listOf(
        Endereco(complemento = "casa"),
        Endereco(complemento = "apartamento"),
        Endereco()
    )
        .filter(predicate = { endereco -> endereco.complemento.isNotEmpty() })
        .let(block = (::println))
}