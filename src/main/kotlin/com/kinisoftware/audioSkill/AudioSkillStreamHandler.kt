package com.kinisoftware.audioSkill

import com.amazon.ask.SkillStreamHandler
import com.amazon.ask.Skills
import com.kinisoftware.audioSkill.handler.*
import com.kinisoftware.audioSkill.handler.playback.*
import com.kinisoftware.audioSkill.interceptor.LogRequestInterceptor
import com.kinisoftware.audioSkill.interceptor.LogResponseInterceptor

class AudioSkillStreamHandler : SkillStreamHandler(skill) {
    companion object {
        private val skill = Skills.standard()
            .addRequestInterceptor(LogRequestInterceptor())
            .addResponseInterceptor(LogResponseInterceptor())
            .addRequestHandlers(
                PlayTheAudioHandler(),
                ResumeIntentHandler(),
                HelpIntentHandler(),
                PlaybackStoppedHandler(),
                PlaybackFailureHandler(),
                PlaybackFinishedHandler(),
                PlaybackNearlyFinishedHandler(),
                PlaybackStartedHandler(),
                RepeatAndStartOverIntentHandler(),
                CancelAndStopIntentHandler(),
                NextAndPreviousIntentHandler(),
                FallbackIntentHandler(),
                SystemExceptionEncounterHandler(),
                SessionEndedRequestHandler()
            )
            .withTableName("skill-audio")
            .withAutoCreateTable(true)
            .withPartitionKeyGenerator { it.getUserId() }
            .build()
    }
}
