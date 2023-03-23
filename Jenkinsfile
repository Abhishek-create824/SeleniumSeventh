pipeline {
agent any  
options {
timestamps()
}
stages {
stage('Checkout SCM ') {
when {
branch 'master'
}
steps {
git CredentialsId: 'Abhishek Git credentials' , url: 'https://github.com/Abhishek-create824/SeleniumSeventh.git'
}
}
stage('Clean') {
steps {
bat "mvn clean"
}
}
stage('Compile') {
steps {
bat "mvn compile"
}
}
stage('Test') {
steps {
bat "mvn test -DsuiteXmlFile=testng.xml"
}
}
stage('Send Email') {
steps {
echo "Sending Email"
}
}
post {
failure {
email To: 'abhishek260297@gmail.com',
subject: 'Test',
body: readFile("target/surefire-reports/emailable-report.html"),
mimeType: 'text/html'
}
}
}
}