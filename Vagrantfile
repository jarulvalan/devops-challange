VM_BOX  = 'ubuntu/trusty64'
NETWORK = 'forwarded_port'
GUEST_PORT = 80
HOST_PORT = 9001
Vagrant.configure(2) do |config|

    config.vm.box = VM_BOX
    config.vm.hostname= "Flask-app"
    config.vm.network NETWORK, guest: GUEST_PORT, host: HOST_PORT
    config.vm.provider "virtualbox" do |vb|
        vb.memory = 1024
        vb.customize ["modifyvm" , :id, "--cpuexecutioncap", "40"]
    end
    config.vm.provision "ansible" do |ansible|
        ansible.playbook = "devops_challenge.yml"
    end

end
