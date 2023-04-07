
jar -cf framework_M.jar -C .\ProjectServlet\build\web\WEB-INF\classes .
xcopy framework_M.jar .\TestProject\build\web\WEB-INF\lib
jar -cvf TestProject.war -C .\TestProject\build\web\ .
copy TestProject.war C:\MyWebServer\apache-tomcat-10.0.20\webapps


