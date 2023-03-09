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
				username: 'admin',
                password: 'nexus',
				groupId: 'tn.esprit.rh', 
				nexusUrl: '192.168.2.20:8081', 
				nexusVersion: 'nexus3', 
				protocol: 'http', 
				repository: 'achatapp-release', 
				version: "${mavenPom.version}"
				}				
			}
        }  
        
    }
}