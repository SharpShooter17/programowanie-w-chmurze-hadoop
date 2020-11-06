#!/bin/bash

echo Entrypoint script

echo copy my ssh-key to shared volume
cp /root/.ssh/id_rsa.pub /ssh-keys/node-worker.pub

echo copy ssh key
cat /ssh-keys/*.pub > /root/.ssh/authorized_keys
echo copy ssh key success

echo run entrypoint command: $@
exec "$@"