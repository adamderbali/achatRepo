
pipeline {
    

    agent any
    
       tools {
          maven 'M2_HOME'
      }



    stages {
	
        stage('GIT Checkout') 
		{
            steps 
			{
                echo 'Pulling project from GIT...';
                git branch: 'jawherbenhamed',
                url : 'https://github.com/adamderbali/achatRepo.git',
                credentialsId : 'e344e277-5a08-40df-8aaa-152740d92aaa'
                
            }
        }
        
        stage ('Maven Clean')
		{
            steps 
			{
                sh 'mvn clean'
            }
        }
        
		stage ('Maven Compile')
		{
            steps 
			{
                sh 'mvn compile'
            }
        }
		
		stage ('Maven Sonar') 
		{
            steps 
			{
                sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.2.20:9000 -Dsonar.login=admin -Dsonar.password=Jawher123'
            }
        }
		
        stage ('Maven Test')
		{
            steps 
			{
                sh 'mvn test'    
            }
        }
        
		stage('Maven Build')
	    {
            steps 
			{
                sh 'mvn package'
            }
        }
		
		stage ('Maven Install')
		{
            steps 
			{
                sh 'mvn install'    
            }
        }
    
        stage('Deployement To Nexus')
		{
            steps
			{
				script
				{
					def mavenPom = readMavenPom file: 'pom.xml'
					
				nexusArtifactUploader artifacts:
				[
					[
						artifactId: 'achat',
						classifier: '',
						file: "target/achat-${mavenPom.version}.jar",
						type: 'jar'
					]
				], 
				
				credentialsId: 'nexus', 
				groupId: 'tn.esprit.rh', 
				nexusUrl: '192.168.2.20:8081', 
				nexusVersion: 'nexus3', 
				protocol: 'http', 
				repository: 'simpleapp-release', 
				version: "${mavenPom.version}"
				}				
			}
        }  


		stage('Docker Build Image'){
                steps
				{
                    script
					{
                        sh 'docker build -t achat-1.1.3 .'
                        sh 'docker build -t mysql .'
						
                    }                   
                }
            }
      
      
        stage('Docker Push Image'){
                steps
				{
                    script
					{
                        
                        sh 'docker login -u ademderbali -p dockerhub'
                             
                        sh 'docker tag  achat-1.1.3 ademderbali/achat-1.1.3:tag1'    
                        sh 'docker push ademderbali/achat-1.1.3' 
                        
                        sh 'docker tag  mysql ademderbali/mysql:8'    
                        sh 'docker push ademderbali/mysql'    
                         
                          
                            
                    }
                   
                }
        }
        stage('Docker-Compose')
		{
                steps
				{
                    script
					{
                        sh 'docker-compose up'
                    }
                   
                }
               
            }
    }
}