package keisuke.line_bot

import com.linecorp.bot.model.event.MessageEvent
import com.linecorp.bot.model.event.message.TextMessageContent
import com.linecorp.bot.model.message.TextMessage
import com.linecorp.bot.spring.boot.annotation.EventMapping
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler

@LineMessageHandler
class WebhookController {
	@EventMapping
	@Throws(Exception::class)
	fun handlerTextMessageEvent(event: MessageEvent<TextMessageContent>): ArrayList<TextMessage> {
		val messageList = ArrayList<TextMessage>()
		println("event: {$event}")

		val message = event.message
		messageList.add(TextMessage(message.text))
		return messageList
	}
}
