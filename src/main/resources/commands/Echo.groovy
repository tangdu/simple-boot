
import org.crsh.cli.Command
import org.crsh.cli.Usage
import org.crsh.command.InvocationContext


class Echo{

	@Usage("Say Hello")
	@Command
	def main(InvocationContext context) {
		def s='no more time,baby'
		return "我知道，${s}"
	}
}




