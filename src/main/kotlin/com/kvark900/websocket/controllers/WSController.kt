package com.kvark900.websocket.controllers

import com.kvark900.websocket.dto.Message
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.web.util.HtmlUtils

@Controller
class WSController {

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    fun getMessage (message : Message): Message {
        Thread.sleep(500)
        return Message(HtmlUtils.htmlEscape(message.content))
    }
}