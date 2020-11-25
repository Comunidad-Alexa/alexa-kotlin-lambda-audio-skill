package com.kinisoftware.audioSkill.handler.playback

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.interfaces.audioplayer.PlaybackNearlyFinishedRequest
import com.amazon.ask.request.Predicates

class PlaybackNearlyFinishedHandler : RequestHandler {

    override fun canHandle(input: HandlerInput) =
        input.matches(Predicates.requestType(PlaybackNearlyFinishedRequest::class.java))

    override fun handle(input: HandlerInput) = input.responseBuilder.build()
}
