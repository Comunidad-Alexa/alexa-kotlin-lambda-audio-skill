package com.kinisoftware.audioSkill.handler.playback

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.model.interfaces.audioplayer.ErrorType
import com.amazon.ask.model.interfaces.audioplayer.PlaybackFailedRequest
import com.amazon.ask.request.Predicates
import com.kinisoftware.audioSkill.audio.PlayAudioResponseBuilder
import java.util.*

class PlaybackFailureHandler : RequestHandler {

    override fun canHandle(input: HandlerInput) =
        input.matches(Predicates.requestType(PlaybackFailedRequest::class.java))

    override fun handle(input: HandlerInput): Optional<Response> {
        val request = input.requestEnvelope.request
        val intentRequest = request as PlaybackFailedRequest

        return when (intentRequest.error.type) {
            ErrorType.MEDIA_ERROR_INTERNAL_DEVICE_ERROR -> input.responseBuilder.build()
            else -> PlayAudioResponseBuilder.buildFallbackResponse(input)
        }
    }
}
