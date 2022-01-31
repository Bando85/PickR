
    node {
        def remote = [:]
          remote.name = 'test'
          remote.host = '192.168.1.4'
          remote.user = 'pi'
          remote.password = 'hNjm647'
          remote.allowAnyHosts = true
          stage('Remote SSH') {
            writeFile file: 'abc.sh', text: 'ls -lrt'
            sshPut remote: remote, from: 'abc.sh', into: './share'
          }
    }