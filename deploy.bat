call mvn package
call mvn deploy:deploy-file -Durl=file:C:\Users\Talon\Dropbox\Git\repo\releases -Dfile=target\Toolkit-1.0.jar -DgroupId=org.nolat -DartifactId=Toolkit -Dversion=1.0 -Dpackaging=jar
call cd C:\Users\Talon\Dropbox\Git\repo\releases
call git add .
call git commit -m "Updating Toolkit"
call git push
call echo "Finished deploying"