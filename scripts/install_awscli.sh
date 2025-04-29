#!/bin/bash

cd $HOME

wget -q "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -O awscliv2.zip

unzip -q awscliv2.zip

./aws/install --install-dir $HOME/aws-cli --bin-dir $HOME/.local/bin
