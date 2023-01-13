package keisuke.line_bot

import com.linecorp.bot.model.event.Event
import com.linecorp.bot.model.event.MessageEvent
import com.linecorp.bot.model.event.message.TextMessageContent
import com.linecorp.bot.model.message.Message
import com.linecorp.bot.model.message.TextMessage
import com.linecorp.bot.spring.boot.annotation.EventMapping
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
@LineMessageHandler
class EchoApplication {
	@EventMapping
	fun handleTextMessageEvent(event: MessageEvent<TextMessageContent>): Message {
		println("event: $event")
		return TextMessage(event.message.text)
	}

//	@EventMapping
//	fun handleDefaultMessageEvent(event: Event) {
//		println("event: $event")
//	}

}

fun main(args: Array<String>) {
	SpringApplication.run(EchoApplication::class.java, *args)
}
