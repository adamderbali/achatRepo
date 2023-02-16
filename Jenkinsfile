
pipeline {
    

    agent any
    
       tools {
          maven 'M2_HOME'
      }



    stages {
	
		stage('maven vr')
		{
			steps 
			{
				sh 'mvn --version'
			}
		}
		
		
        stage('Checkout GIT') 
		{
            steps 
			{
                echo 'Pulling project from GIT...';
                git branch: 'ademDerbali',
                url : 'https://github.com/adamderbali/achatRepo.git',
                credentialsId : 'e344e277-5a08-40df-8aaa-152740d92aaa'
                
            }
        }
        
        stage ('MVN CLEAN')
		{
            steps 
			{
                sh 'mvn clean'
            }
        }
        
       stage('Maven Build')
	   {
            steps 
			{
                sh 'mvn package'
            }
        }
		
        stage ('MVN TEST')
		{
            steps 
			{
                sh 'mvn test'    
            }
        }
        
		stage ('MVN COMPILE')
		{
            steps 
			{
                sh 'mvn compile'
            }
        }
        
		stage ('MVN INSTALL')
		{
            steps 
			{
                sh 'mvn install'    
            }
        }
    
        stage('Nexus')
		{
            steps
			{
				nexusArtifactUploader artifacts:
				[
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
				repository: 'maven-releases', 
				version: '1.1.0'   
			}
        }  
    }
}