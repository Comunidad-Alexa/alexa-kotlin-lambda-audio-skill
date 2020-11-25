package com.kinisoftware.audioSkill

import com.amazonaws.services.dynamodbv2.model.InternalServerErrorException

object Translations {

    enum class TranslationKey {
        WELCOME, HELP, THANKS, FALLBACK, NO_FEATURE
    }

    fun getMessage(language: String, messageKey: TranslationKey) =
        messages.getValue(language)[messageKey]
            ?: throw InternalServerErrorException("There is not messages for $language - $messageKey")

    private val messages = mapOf(
        "es" to mapOf(
            TranslationKey.WELCOME to "¡Gracias por usar esta skill!",
            TranslationKey.HELP to "Para usar esta skill simplemente tienes que invocarla y reproducirá el audio. ¿Quieres que lo reproduzca?",
            TranslationKey.THANKS to "¡Gracias por usar esta skill!",
            TranslationKey.FALLBACK to "Vaya, algo ha ido mal. Inténtalo más tarde",
            TranslationKey.NO_FEATURE to "Vaya, no puedo cambiar de audio, lo siento"
        ),
        "en" to mapOf(
            TranslationKey.WELCOME to "Thank your for using this skill!",
            TranslationKey.HELP to "To use this skill just invoke it and the audio will be played right away. Do you want me to play the audio now?",
            TranslationKey.THANKS to "Thank your for using this skill!",
            TranslationKey.FALLBACK to "Ups, there is some problem here. Please, try later again.",
            TranslationKey.NO_FEATURE to "Ups, I cannot change the audio. It is just a radio streaming. Sorry"
        ),
        "pt" to mapOf(
            TranslationKey.WELCOME to "Obrigado por usar essa skill!",
            TranslationKey.HELP to "Para usar esta habilidade, basta invocá-la e ela reproduzirá o áudio. Você quer que eu jogue agora?",
            TranslationKey.THANKS to "Obrigado por usar essa skill!",
            TranslationKey.FALLBACK to "Uau, algo deu errado. Tente mais tarde",
            TranslationKey.NO_FEATURE to "Nossa, não consigo mudar o áudio, desculpe"
        )
    )
}