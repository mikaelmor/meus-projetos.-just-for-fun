import sys
from rich import print
from time import sleep
import time

def printLyrics():
    lyrics = [
        ("Can you help me out,", 0.2), 
        ("can you lead me a hand?", 0.4), 
        ("It's safe to say- ", 0.03),
        ("I'm stuck again", 0.2),
        ("Trapped between this lif and the light", 0.4),
        ("I just can't figure out-", 0.03),
        ("How to meke it right", 0.3),
        ("A thousand times be--fore", 0.05),
        ("I've wondering if there's something more", 0.4),
        ("Something more", 0.2),
        ("I feel it's gonna rain like this for days", 0.03),
        ("So let it rain down and wash everything away", 0.4),
    ]

    for line, char_delay in lyrics:
        for char in line:

            sys.stdout.write(char)
            sys.stdout.flush()
            sleep(char_delay) 
        
        print() 
        sleep(0.5) 

if __name__ == "main":
    printLyrics()
   
