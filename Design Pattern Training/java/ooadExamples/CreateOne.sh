#!/bin/bash
LINE="============================================================"
while read A; do
	echo $LINE
	echo "$A"
	echo $LINE
	cat $A
	echo " "
done < <(find -name 'Q*.java' | sort)  > "CombinedFile.txt"
