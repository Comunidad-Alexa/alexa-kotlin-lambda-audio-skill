package com.kinisoftware.audioSkill.handler

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.request.Predicates
import com.kinisoftware.audioSkill.audio.PlayAudioResponseBuilder

class RepeatAndStartOverIntentHandler : RequestHandler {

    override fun canHandle(input: HandlerInput) =
        input.matches(Predicates.intentName("AMAZON.StartOverIntent"))
            .or(input.matches(Predicates.intentName("AMAZON.RepeatIntent")))

    override fun handle(input: HandlerInput) = PlayAudioResponseBuilder.buildAudioResponse(input)
}
