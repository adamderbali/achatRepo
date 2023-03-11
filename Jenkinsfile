pipeline {
    

    agent any
    
       tools {
          maven 'M2_HOME'
      }
     
      environment {
          MAVEN_OPTS = "-Xmx2g"
     }

    stages {
	
        stage('GIT Checkout') 
		{
            steps 
			{
                echo 'Getting project from GIT...';
                git branch : 'ghadaFridhi',
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
                sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.56.100:9000 -Dsonar.login=admin -Dsonar.password=sonar'
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
    

             stage('Docker Build Image'){
                steps
				{
                    script
					{
                        sh 'docker build -t achat-1.0.0 .'
                        sh 'docker build -t mysql .'
						
                    }                   
                }
            }
      
      
        stage('Docker Push Image'){
                steps
				{
                    script
					{
                        
                        sh 'docker login -u ghadaf -p dockerghada'
                             
                        sh 'docker tag  achat-1.0.0 ghadaf/achat-1.0.0:tag1'    
                        sh 'docker push ghadaf/achat-1.0.0' 
                        
                        sh 'docker tag  mysql ghadaf/mysql'    
                        sh 'docker push ghadaf/mysql'    
                         
                          
                            
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
            
        post {
        always {
            emailext body: 'Le pipeline est terminé !', 
                subject: 'Rapport de pipeline', 
                to: 'ghada.fridhi@esprit.tn'
        }
    }
      
    }
}