# evento_master
Programa criado em Java para controle de evento.
O evento é separado em 2 etapas com coffee-break em cada etapa.

# O programa consiste em:
Cadastros:
* Pessoa
* Sala de evento
* Espaço de café

Consultas:
* Pessoas cadastradas, com exibição das salas e espaço café em cada etapa do evento
* Salas de evento cadastradas, com exibição das pessoas que estarão na sala em cada etapa do evento
* Espaço de café cadastrados, com exibição das pessoas que estarão no espaço em cada etapa do evento

## Regras
O programa separa automaticamente as pessoas cadastradas entre as salas disponíveis com base em 2 regras:
* A diferença máxima de participantes nas salas é de 1 pessoa (exceto quando a sala atingir sua capacidade máxima)
* Metade dos participantes trocam de sala para promover a troca de conhecimentos (enquanto a capacidade máxima da sala não for atingida)

Além disso o programa separa automaticamente as pessoas cadastradas entre os espaços de café disponiveis com base em 1 regra:
* Cada pessoa deve realizar os 2 coffee-break em espaços diferentes (exceto quando o espaço atingir sua capacidade máxima)

## Banco de dados
O sistema utiliza um banco de dados feito para MySQL que está disponível no Release aqui no GitHub, arquivo "project.sql".
É de suma importância realizar a criação do banco de dados visto que sem ele o programa não funcionará!

## Funcionalidades
O sistema foi desenvolvido com o princípio de que não importa qual cadastro seja realizado primeiro, o sistema funcionará corretamente.
Exemplos:
* Se for cadastrado as pessoas primeiro e ainda não estiver sido cadastrado as salas de evento/espaços de café, ao consultar as pessoas cadastradas o sistema exibirá a mensagem "Nenhuma sala disponível/cadastrada!" e/ou "Nenhum espaço café disponível/cadastrado!"
* A mensagem acima também é exibido quando a capacidade máxima das salas de evento e/ou espaços de café forem atingidos
* Ao cadastrar uma sala de evento **depois** de cadastrar as pessoas o sistema efetuará automaticamente a separação e inclusão das pessoas nas salas, seguindo as regras pré-estabelecidas
* O mesmo vale para um espaço café ao ser cadastrado **depois** das pessoas.

## Testes Unitários
O sistema conta com testes unitários para garantir o correto preenchimento das entidades, permitindo assim testar se o sistema está validando o preenchimento das classes corretamente, evitando erros no banco de dados.

## Bibliotecas utilizadas
Todas as bibliotecas utilizadas são gratuitas.
Elas estão disponíveis no Release do programa, disponível aqui no GitHub.

## Gerar o executável (jar)
No Release do programa aqui no GitHub já está disponível o JAR compilado, mas caso seja do interesse você pode baixar o projeto na IDE de sua preferência, adicionar as bibliotecas e depois gerar o JAR
Gerar o JAR através de linha de comando deve ser feito apenas por pessoas que possuem conhecimento de tal processo pois caso algum comando seja "esquecido" o programa não funcionará corretamente!

## JDK
O JDK utilizado no projeto foi o JDK 15 pois o programa não possui finalidade comercial e não necessida de uma licença paga do JDK!
