
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
        
      
        

     stage ('MVN INSTALL') {
            steps {
                sh script 'mvn install'
                
            }
        }
        
    
        
        
         stage('Nexus'){
            steps{
              


nexusArtifactUploader artifacts: [
[
artifactId: 'achat',
 classifier: '',
 file: 'target/achat-1.1.0.jar',
 type: 'jar'
]
], 
credentialsId: 'nexus', 
groupId: 'tn.esprit.rh', 
nexusUrl: '192.168.2.20:8081', 
nexusVersion: 'nexus3', 
protocol: 'http', 
repository: 'http://192.168.2.20:8081/repository/maven-releases', 
version: '1.1.0'





                
       
            
        }
        }
   
        
    
        
    }
}