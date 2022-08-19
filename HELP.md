To start:

aurelien.poscia@aurelienposcia-MacBook-Pro test-scanner-maven % 
mvn clean verify sonar:sonar -Dsonar.projectKey=aposcia_test-scanner-maven_AX-2OxgDzT9fFRaD3kBc -Dsonar.host.url=http://localhost:9000 -Dsonar.login=d7a94022c8adcb32f282e8e9bea75ff5ee2f6fdc  


Only if pr deco wanted
-Dsonar.pullrequest.key=1 -Dsonar.pullrequest.branch=feature/ap/change_pr -Dsonar.pullrequest.base=master
