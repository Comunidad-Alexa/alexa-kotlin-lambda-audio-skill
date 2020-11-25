package com.kinisoftware.audioSkill.audio

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.model.Response
import com.amazon.ask.model.interfaces.audioplayer.PlayBehavior
import com.kinisoftware.audioSkill.AUDIO_URL
import com.kinisoftware.audioSkill.FALLBACK_AUDIO_URL
import com.kinisoftware.audioSkill.PERSISTENT_ATTRIBUTES_OFFSET_KEY
import java.util.*

object PlayAudioResponseBuilder {
    fun buildAudioResponse(input: HandlerInput, offsetInMilliseconds: Long? = 0L): Optional<Response> {
        input.attributesManager.persistentAttributes[PERSISTENT_ATTRIBUTES_OFFSET_KEY] = offsetInMilliseconds
        input.attributesManager.savePersistentAttributes()

        return input.responseBuilder
            .addAudioPlayerPlayDirective(
                PlayBehavior.REPLACE_ALL,
                offsetInMilliseconds,
                null,
                "audioSkill",
                System.getenv(AUDIO_URL)
            )
            .build()
    }

    fun buildFallbackResponse(input: HandlerInput): Optional<Response> {
        return input.responseBuilder
            .addAudioPlayerPlayDirective(
                PlayBehavior.REPLACE_ALL,
                0L,
                null,
                "audioSkill",
                System.getenv(FALLBACK_AUDIO_URL)
            )
            .build()
    }
}