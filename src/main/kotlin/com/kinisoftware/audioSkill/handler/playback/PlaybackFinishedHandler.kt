package com.kinisoftware.audioSkill.handler.playback

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.interfaces.audioplayer.PlaybackFinishedRequest
import com.amazon.ask.request.Predicates

class PlaybackFinishedHandler : RequestHandler {

    override fun canHandle(input: HandlerInput) =
        input.matches(Predicates.requestType(PlaybackFinishedRequest::class.java))

    override fun handle(input: HandlerInput) = input.responseBuilder.build()
}
