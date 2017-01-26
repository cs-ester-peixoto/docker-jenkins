node{
	stage('Build'){
		sh 'make'
		archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
	}
	stage('Test'){
		sh 'make check || true'
		junit '**/target/*.xml'
	}
	stage('Deploy'){
		if (currentBuild.result == 'SUCCESS') {
			sh 'make publish'
		}
	}
}