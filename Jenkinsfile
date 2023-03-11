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
                git branch: 'helaMaroub',
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
                sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.33.10:9000 -Dsonar.login=admin -Dsonar.password=sonar'
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
				nexusUrl: '192.168.33.10:8081', 
				nexusVersion: 'nexus3', 
				protocol: 'http', 
				repository: 'simpleapp-release', 
				version: "${mavenPom.version}"
				}				
			}
        }  
		 
       stage('Docker Build Image')
		{
                steps
				{
                    script
					{
                        sh 'docker build -t achat-1.1.2 .'
                        sh 'docker build -t mysql .'
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