package com.kinisoftware.audioSkill.handler.playback

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.interfaces.audioplayer.PlaybackStartedRequest
import com.amazon.ask.request.Predicates

class PlaybackStartedHandler : RequestHandler {

    override fun canHandle(input: HandlerInput) =
        input.matches(Predicates.requestType(PlaybackStartedRequest::class.java))

    override fun handle(input: HandlerInput) = input.responseBuilder.build()
}
