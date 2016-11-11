println 'Running checkstyles'

def env = System.getenv().collect { k, v -> "$k=$v" }
def eeHome = new File(args[0])

modifiedModules = new HashSet()
"hg st".execute(env, eeHome).text.eachLine{ modifiedModules.add(it.substring(2, it.indexOf('\\')))}

modifiedModules.forEach{
	println it
	moduleHome = new File(eeHome.getAbsolutePath() + '/' + it)
	process = "cmd /C mvn checkstyle:check@validate".execute(env, moduleHome)
	output = new StringBuffer();
	process.waitForProcessOutput(output, System.err)
	
	if (process.exitValue() != 0) {
		println ' - errors found'
		println output.subSequence(output.indexOf('Starting audit'), output.indexOf('Audit done.') + 10)
	}
}
