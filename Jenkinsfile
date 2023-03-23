pipeline {
    agent any
   tools {
       jdk 'Java 11'
       maven 'Maven 3.6.3'
     }
     stages {
         stage('Checkout') {
             steps  {
                git credentialsId: 'Abhishek Git credentials' , url: 'https://github.com/Abhishek-create824/SeleniumSeventh.git'
                     }
                            }
         stage('Clean') {
             steps  {
                bat "mvn clean "
                     }
                            }      
           stage('Compile') {
             steps  {
                bat "mvn compile "
                     }
                            }                 
          stage('Test') {
             steps  {              
                bat "mvn test -DsuiteXmlFile=testng.xml"
                    }
                          } 
        stage('Download') {
            steps {
            echo "Sending email "
                  }
       post {
        success {
                  mail to: 'abhishek260297@gmail.com',
                  subject: "Email Report from - '${env.JOB_NAME}'",
                  body: readFile("target/surefire-reports/emailable-report.html"),
                  mimeType:'text/html'
                 }
             }
                          }
                          
         stage('User input') {
             input {
                 message "Should we continue?"
                 ok "Yes"
                   }
                             }
         stage('Email') {
            steps {
            echo "Sending email "
                  }
       post {
        success {
                  mail to: 'abhishek260297@gmail.com',
                  subject: "Email Report from - '${env.JOB_NAME}'",
                  body: readFile("target/index.html"),
                  mimeType:'text/html'
                 }
}
}

}
}
