node{
	stage('Checkout'){
		checkout scm
	}
	stage('Build'){
		sh './dockerBuild.sh'
		// archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
	}
	stage('Test'){
		//sh 'make check || true'
		//junit '**/target/*.xml'
	}
	stage('Deploy'){
		//if (currentBuild.result == 'SUCCESS') {
		//	sh 'make publish'
		//}
		sh './dockerPushToRepo.sh'
	}
}