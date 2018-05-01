#PROTOCOLUL DE COMUNICARE


**Formatul mesajelor** - *[/command parameter]*

**Comenzile suportate de server**
	*[/hello name] - Show the Name
	*[/help] - Show available commands
	*[/horoscope sign] - Horoscope for current date
	*[/random Number1 Number2] - Random a number between Number1 and Number2
	*[/time] - Show Current Time

**Exemplu de raspuns**
	* send: /hello Name
		*response: Name
	* send: /help
		*response: [/hello name] - Show the Name
			   [/help] - Show available commands
	                   [/horoscope sign] - Horoscope for current date
			   [/random Number1 Number2] - Random a number between Number1 and Number2
			   [/time] - Show Current Time
	*send: /horoscope leu
		*response: Show horoscope for current date and indicate sign
	*send: /horoscope leo
		*response: Incorrect Format [/horoscope sign]
	*send: /random 5 20
		*response: An random number between 5 and 20
	*send: /random 20 5
		*response: Incorrect Format [/random Number1 Number2]
	*send: /time
		*response: Show current time
	*send: /time param
		*response:Incorrect Format [/time]
