package com.keridano.pokedex.data

class ErrorResponse(val code: Int, message: String) : Throwable("($code) $message")