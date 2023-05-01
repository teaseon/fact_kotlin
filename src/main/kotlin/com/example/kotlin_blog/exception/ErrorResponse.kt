package com.example.kotlin_blog.exception

import org.springframework.validation.BindingResult

class ErrorResponse(
    errorCode: ErrorCode,
    var errors: List<FieldError> = ArrayList()
) {

    var code:String = errorCode.code
        private set

    var message:String = errorCode.message
        private set

    class FieldError private constructor(
        val field:String,
        val value:String,
        val reason:String?
    ) {
        companion object {
            fun of(bindResult: BindingResult): List<FieldError> = bindResult.fieldErrors.map { error ->
                    FieldError(
                        field = error.field,
                        value = if(error.rejectedValue == null) "" else error.rejectedValue.toString(),
                        reason = error.defaultMessage
                    )
                }
        }
    }

    companion object {
        fun of(code: ErrorCode, bindResult: BindingResult): ErrorResponse = ErrorResponse(
                errorCode = code,
                errors = FieldError.of(bindResult)
            )

        fun of(code: ErrorCode): ErrorResponse = ErrorResponse(
            errorCode = code
        )

    }
}