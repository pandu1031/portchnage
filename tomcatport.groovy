//Declarative pipeline 
pipeline{
    agent any 
    parameters {
        string(name:'SERVERIP', defaultvalue:'', description:'Tomcat server')
    }
    stages{
        stage("change port number"){
            steps{
                sh """ ssh -i /tmp/mamu1031.pem ec2-user@${SERVERIP} "sudo sed -zi 's/8080/9080/2' /etc/tomcat/server.xml"
                ssh -i /tmp/mamu1031.pem ec2-user@${SERVERIP} "sudo systemctl restart tomcat"
                 """
            }
        }
    }
}