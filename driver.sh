snap=target/memory-0.0.0-SNAPSHOT.jar
loop=true
java -jar $snap 2>> logs/error.log

while [ "$loop" = "true" ]
do
    content=$(cat /tmp/memory.tmp)
    if [ "$content" = "EXIT" ]
    then
	loop=false
    else
	emacs $content
	java -jar $snap 2>> logs/error.log
    fi
done
