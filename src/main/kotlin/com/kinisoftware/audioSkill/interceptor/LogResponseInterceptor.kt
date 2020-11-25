package com.kinisoftware.audioSkill.interceptor

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.interceptor.ResponseInterceptor
import com.amazon.ask.model.Response
import com.amazon.ask.util.JacksonSerializer
import com.kinisoftware.audioSkill.getUserId
import java.util.*

class LogResponseInterceptor : ResponseInterceptor {
    override fun process(input: HandlerInput, response: Optional<Response>) {
        response.ifPresent {
            println("Response: ${JacksonSerializer().serialize(it)} for ${input.requestEnvelope.getUserId()}")
        }
    }
}