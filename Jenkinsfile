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
                git branch: 'sabrinezekri',
                url : 'https://github.com/adamderbali/achatRepo.git'      
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
                sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.2.20:9000 -Dsonar.login=admin -Dsonar.password=Nesrine2019%'
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
				protocol: 'http', 
				nexusUrl: '192.168.2.20:8081', 
				repository: 'achatapp-release',
				nexusVersion: 'nexus3', 
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
                        
                        sh 'docker login -u sabrinezekri -p Nesrine2019%'
                             
                        sh 'docker tag  achat-1.1.3 sabrinezekri/achat-1.1.3:tag1'    
                        sh 'docker push sabrinezekri/achat-1.1.3' 
                        
                        sh 'docker tag  mysql sabrinezekri/mysql:8'    
                        sh 'docker push sabrinezekri/mysql'    
                         
                          
                            
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