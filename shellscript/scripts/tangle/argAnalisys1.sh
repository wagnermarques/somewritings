#!/usr/bin/bash
x='1'
echo "\$0 => nome do script = $0"
echo "\$1 => primeiro argumento=$1 \$2 retorna o segundo, e assim por diante"
echo "\$# => quantidade de parametros recebidos=$#"
echo "\$@ => representa um array com todos os argumentos passados para o script = $@"
echo "\${@: $#} => ultimo parametro recebido = ${@: $#}"
