package com.kinisoftware.audioSkill.handler.playback

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.model.interfaces.audioplayer.PlaybackStoppedRequest
import com.amazon.ask.request.Predicates
import com.kinisoftware.audioSkill.PERSISTENT_ATTRIBUTES_OFFSET_KEY
import java.util.*

class PlaybackStoppedHandler : RequestHandler {

    override fun canHandle(input: HandlerInput) =
        input.matches(Predicates.requestType(PlaybackStoppedRequest::class.java))


    override fun handle(input: HandlerInput): Optional<Response> {
        val request = input.requestEnvelope.request
        val intentRequest = request as PlaybackStoppedRequest

        input.attributesManager.persistentAttributes[PERSISTENT_ATTRIBUTES_OFFSET_KEY] =
            intentRequest.offsetInMilliseconds
        input.attributesManager.savePersistentAttributes()

        return input.responseBuilder.build()
    }
}
