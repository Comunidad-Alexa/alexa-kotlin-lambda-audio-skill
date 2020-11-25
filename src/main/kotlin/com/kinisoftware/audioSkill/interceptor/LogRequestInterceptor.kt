package com.kinisoftware.audioSkill.interceptor

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.interceptor.RequestInterceptor
import com.amazon.ask.util.JacksonSerializer
import com.kinisoftware.audioSkill.getUserId

class LogRequestInterceptor : RequestInterceptor {
    override fun process(input: HandlerInput) {
        println("Request: ${JacksonSerializer().serialize(input.request)} for ${input.requestEnvelope.getUserId()}")
    }
}