
    node {
        withCredentials([usernameColonPassword(credentialsId: 'b0db40fa-b7f4-45e0-80c4-c78d85926d2f', variable: ''), usernamePassword(credentialsId: 'b0db40fa-b7f4-45e0-80c4-c78d85926d2f', passwordVariable: 'pass', usernameVariable: 'username')]) {

            def remote = [:]

              remote.name = 'test'
              remote.host = '192.168.1.4'
              remote.user = $username
              remote.password = $pass
              remote.allowAnyHosts = true
              stage('Build')

              stage('Remote SSH') {
                writeFile file: 'abc.sh', text: 'ls -lrt'
                 sshPut remote: remote, from: 'abc.sh', into: '/home/pi/share'
              }
        }
    }