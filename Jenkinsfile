
pipeline {
    

    agent any
    
   
    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling project from GIT...';
                git branch: 'ademDerbali',
                url : 'https://github.com/adamderbali/achatRepo.git',
                credentialsId : 'e344e277-5a08-40df-8aaa-152740d92aaa'
                
            }
        }
        
        stage ('MVN CLEAN') {
            steps {
                sh 'mvn clean'
            }
        }
        
        stage ('MVN COMPILE') {
            steps {
                sh 'mvn compile'
            }
        }
        
    
        stage ('MVN TEST') {
            steps {
                sh 'mvn test'
                
            }
        }
        
         stage ('MVN INSTALL') {
            steps {
                sh 'mvn install'
                
            }
        }
        
        
        stage('Maven Build') {
        
            steps {
                    sh 'mvn clean package -DskipTests'
            }
        }
        
        
         stage('Nexus'){
            steps{
                script{
                    def mavenPom = readMavenPom file: 'pom.xml'
                
        nexusArtifactUploader artifacts: [
             [
		    artifactId: 'achat',
                    classifier: '',
                    file: "target/achat-${mavenPom.version}.jar",
                    type: 'jar'
 	    ]
            ],  
                credentialsId: 'nexus',
                groupId: 'tn.esprit.rh.achat',
                nexusUrl: '192.168.2.20:8081',
                nexusVersion: 'nexus3',
                protocol: 'http',
                repository: 'maven-releases',
                version: "${mavenPom.version}"
            }
        }
        }
   
        
    
        
    }
}