Use eclipse.exe from the right directory i.e. b32 for 32 bit or b64 for 64bit.
On command line, 
	java.exe -version
will tell you whether you have 32 bit or 64bit

Ensure JAVA_HOME is set correctly. e.g.
JAVA_HOME=C:\Program Files\Java\jdk1.8.0_25
	
Ensure %JAVA_HOME%\bin is in path i.e. for above JAVA_HOME, path should have
C:\Program Files\Java\jdk1.8.0_25\bin
This value should be before any other path, to avoid overriding of it.

In case eclipse gives error while starting, then probably the right
Java jdk is not getting select. To fix this error, in eclipse.ini file
just before the line "-vmargs" add the following two lines

-vm
C:\Program Files (x86)\Java\jdk1.8.0_25\bin\javaw.exe

Use the exact path of javaw.exe on your PC, in the above line.