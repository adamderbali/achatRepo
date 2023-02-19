
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
                git branch: 'ademDerbali',
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
                sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.2.20:9000 -Dsonar.login=admin -Dsonar.password=sonar'
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


		stage('DOCKER BUILD IMG STAGE'){
                steps
				{
                    script
					{
                        sh 'docker build -t achat-1.1.2 .'
                    }                   
                }
            }
      
      
        stage('DOCKER PUSH IMG STAGE '){
                steps
				{
                    script
					{
                        
                        sh 'docker login -u ademDerbali -p dckr_pat_9AzoyaOin5rvb2KVPbfp0Fo9lSg'
                             
                        sh 'docker tag  achat-1.1.2 ademderbali/achat-1.1.2:latest'    
                        sh 'docker push ademderbali/achat-1.1.2'    
                    }
                   
                }
        }
        stage('DOCKER COMPOSE STAGE')
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