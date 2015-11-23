#! /bin/sh 
# wrapper script
exec java -cp "./dist/data/lang:./dist/accounting.jar:\${CLASSPATH}" \\
    application.accounting.MainClass"\$@"
# end of file \'accounting.sh'

