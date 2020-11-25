package com.kinisoftware.audioSkill.handler

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.model.interfaces.system.ExceptionEncounteredRequest
import com.amazon.ask.request.Predicates
import com.amazon.ask.util.JacksonSerializer
import java.util.*

class SystemExceptionEncounterHandler : RequestHandler {

    override fun canHandle(input: HandlerInput) =
        input.matches(Predicates.requestType(ExceptionEncounteredRequest::class.java))

    override fun handle(input: HandlerInput): Optional<Response> {
        val request = input.requestEnvelope.request
        val intentRequest = request as ExceptionEncounteredRequest

        println("Error: ${JacksonSerializer().serialize(intentRequest)}")
        return input.responseBuilder.build()
    }
}
