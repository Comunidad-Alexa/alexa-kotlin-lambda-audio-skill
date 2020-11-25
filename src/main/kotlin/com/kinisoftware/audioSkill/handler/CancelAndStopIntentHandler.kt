package com.kinisoftware.audioSkill.handler

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.request.Predicates.intentName

class CancelAndStopIntentHandler : RequestHandler {

    override fun canHandle(input: HandlerInput) =
        input.matches(
            intentName("AMAZON.StopIntent")
                .or(intentName("AMAZON.CancelIntent"))
                .or(intentName("AMAZON.PauseIntent"))
        )

    override fun handle(input: HandlerInput) = input.responseBuilder
        .addAudioPlayerStopDirective()
        .withShouldEndSession(true)
        .build()
}
