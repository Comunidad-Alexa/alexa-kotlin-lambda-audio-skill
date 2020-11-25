package com.kinisoftware.audioSkill.handler

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates.intentName
import com.kinisoftware.audioSkill.PERSISTENT_ATTRIBUTES_OFFSET_KEY
import com.kinisoftware.audioSkill.audio.PlayAudioResponseBuilder
import java.math.BigDecimal
import java.util.*

class ResumeIntentHandler : RequestHandler {

    override fun canHandle(input: HandlerInput) = input.matches(intentName("AMAZON.ResumeIntent"))

    override fun handle(input: HandlerInput): Optional<Response> {
        return input.attributesManager.persistentAttributes[PERSISTENT_ATTRIBUTES_OFFSET_KEY]?.let {
            PlayAudioResponseBuilder.buildAudioResponse(input, (it as BigDecimal).longValueExact())
        } ?: PlayAudioResponseBuilder.buildAudioResponse(input)
    }
}
