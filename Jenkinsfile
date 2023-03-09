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
    }
}