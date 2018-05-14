java -jar target/memory-0.0.0-SNAPSHOT.jar

loop=true

while [ "$loop" = "true" ]
do
    content=$(cat /tmp/memory.tmp)
    if [ "$content" = "EXIT" ]
    then
	loop=false
    else
	emacs $content
	java -jar target/memory-0.0.0-SNAPSHOT.jar
    fi
done


# write the command to a file (from java)
# have the script read the file and open emacs from that
# rerun the java command
