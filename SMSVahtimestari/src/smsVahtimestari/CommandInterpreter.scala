package smsVahtimestari
import Commands._
import smsVahtimestari.commands.Sauna

object CommandInterpreter {
	var topic: String = null

	def interpret (msg: String): String = {
		val wordList = msg.split(' ').map(_.toLowerCase.trim)
		var commandToCall: StatusTrait = null
		
		for (cmd <- Commands.list) {
			if (wordList.exists(_ == cmd.toString)) {
				commandToCall = cmd
			}
		}
		
		if (commandToCall == null) {
			commands.Help.status
		}
		
		else if (topic != commandToCall.toString) {
			topic = commandToCall.toString
			commandToCall.status
		}
		
		else {
			"asd"
		}
	}
}
