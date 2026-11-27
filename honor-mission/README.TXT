TRABALHO DE IPOO - ENTREGA FINAL

Nome do jogo: Honor Mission

Integrantes do grupo que realmente contribuíram no trabalho:
- Mateus Cunha
- Gabriel Pedrozo
- Mirella Militani

Escreva abaixo de cada Requisito se ele foi atendido no projeto ou não.

REQUISITOS DE JOGABILIDADE

Nome da classe que atende ao requisito J4.1 (Deve existir um mundo, que podemos chamar de tela inicial, que mostra o nome do jogo e instruções de como jogar).
R.: TelaInicial (nome do jogo na imagem de fundo) e TelaInstrucoes (instruções de como jogar)

Nome da classe que atende ao requisito J4.2 (Deve existir um mundo que é a primeira fase do jogo).
R.: Patio (CasaVigia é um ambiente interno da mesma fase)

Indicar sim ou não, se o jogo atende ao requisito J4.3 (Deve ser possível terminar o jogo com vitória ou derrota e isso deve ser informado de alguma forma para o jogador).
R.: Sim. Vitória ao derrotar todos os patifes na ReservaArmamento (TelaVitoria); derrota ao perder todas as vidas (TelaDerrota).

Nome da classe que atende ao requisito J4.4 (Deve existir um ator que é controlado pelo jogador).
R.: Jogador

Nomes das classes que atendem ao requisito J4.5 (Devem existir pelo menos dois tipos de atores que representam inimigos que precisem ser atacados ou evitados).
R.: Rato (vagueia, persegue e morde) e Vigia (patrulha e atira). Ambos herdam de Vilao.

Nome da classe que atende ao requisito J4.6 (Deve existir pelo menos um tipo de ator que representa um item que o jogador poderá coletar no jogo).
R.: Moeda e Vassoura

Nome da classe que atende ao requisito J4.7 (Deve existir pelo menos um tipo de ator que representa um obstáculo para o jogador).
R.: Obstaculo, Laser

Indicar sim ou não, se o jogo atende ao requisito J4.8 (Deve existir alguma forma de pontuação e deve ser possível que o jogador vença o jogo com diferentes pontuações. A pontuação deve aparecer na tela do jogo durante toda a partida).
R.: Sim (PainelPontuacao exibe os pontos; ratos, moedas, rádio e patifes dão pontos)

Nomes dos arquivos utilizados que atendem ao requisito J4.9 (O jogo deve ter sons de efeitos sonoros e deve usar, pelo menos, três arquivos de áudio diferentes).
R.: vassourada.wav, rato_morrendo.wav, dano.wav, pegar_item.wav, mordida.wav, tiro.wav, abrindo_porta.wav

Nome(s) do(s) arquivo(s) utilizado(s) que atende(m) ao requisito J4.10 (O jogo deve ter som de fundo (pelo menos um)).
R.: avante_camaradas.wav

Nomes das classes que atendem ao requisito J5.1 (A tela inicial feita na primeira entrega será dividida em dois mundos: tela inicial e tela de instruções. Através da tela inicial deve ser possível disparar o início do jogo ou disparar a tela com as instruções do jogo).
R.: TelaInicial e TelaInstrucoes (acionadas por BotaoIniciar e BotaoInstrucoes)

Nome da classe que atende ao requisito J5.2 (Deve existir um mundo que é a segunda fase do jogo).
R.: Quartel (o Museu é um ambiente interno da mesma fase)

Nome da classe que atende ao requisito J5.3 (Deve existir um mundo que é a terceira fase do jogo e que tenha um ator que é o inimigo final a ser derrotado (chefão)).
R.: ReservaArmamento, com o inimigo final Patife

Nome(s) do(s) arquivo(s) utilizado(s) que atende(m) ao requisito J5.4 (Deve existir pelo menos mais um tipo de ator (além dos dois da primeira entrega) que representam inimigos que precisem ser atacados ou evitados (sem contar o chefão)).
R.: Cachorro (persegue e morde o jogador; herda de Vilao)

Nomes das classes que atendem ao requisito J5.5 (Deve existir pelo menos mais dois tipos de atores que representam itens que o jogador poderá coletar no jogo (além do item da primeira entrega)).
R.: Radio, Cartao e Arma

Nome da classe que atende ao requisito J5.6 (Deve existir pelo menos mais um tipo de ator que representa um obstáculo para o jogador (além do obstáculo da primeira entrega). Poderia ser, por exemplo, ser uma parede, uma pedra, uma armadilha, etc).
R.: Lasers (armadilha do Museu que tira vida do jogador)

Nomes dos arquivos utilizados que atendem ao requisito J5.7 (O jogo deve usar pelo menos mais dois arquivos de áudio, além dos usados na primeira entrega).
R.: rosnado_assustador.wav, patife.wav, abre_portao.wav, desativa-laser.wav, fibra_de_heroi.wav, toque_funebre.wav

Indicar sim ou não, se o jogo atende ao requisito J5.8 (Deve existir um mundo que aparece ao final do jogo e que mostre se o jogador venceu ou perdeu (vitória ou game over). Nele devem ser exibidos os pontos obtidos pelo jogador em cada fase, e no total e o que tempo durou a partida).
R.: Sim (TelaVitoria e TelaDerrota, que herdam de TelaResultado: pontos por fase, total e tempo)

Indicar sim ou não, se o jogo atende ao requisito J5.9 (Deve ser possível reiniciar o jogo sem que o usuário tenha que pressionar o botão "Executar" (ou "Run") do Greenfoot).
R.: Sim (BotaoReiniciar chama Partida.iniciar())

REQUISITOS DE IMPLEMENTAÇÃO - Indicar sim ou não em todas as questões.

I4.1 O trabalho deve usar corretamente os conceitos de Classes, Objetos e Encapsulamento.
R.: Sim
I4.2 O trabalho deve usar corretamente os conceitos de Abstração e Modularização.
R.: Sim
I4.3 O trabalho deve usar corretamente os conceitos de atributos, variáveis locais e parâmetros.
R.: Sim
I4.4 O trabalho deve usar corretamente os conceitos de atributos e métodos estáticos.
R.: Sim (Partida, Pontuacao, Vidas, Museu.desativarLasers, constantes)
I4.5 O trabalho deve ser implementado com bom design de classes: baixo acoplamento, alta coesão (não ter replicação de código), com design baseado em responsabilidade e sem acoplamento implícito.
R.: Sim
I4.6 O código deve estar legível, organizado e comentado.
R.: Sim
I4.7 A implementação deve, necessariamente, utilizar o Greenfoot versão 3.9.0 (veja ANEXO A2).
R.: Sim
I4.8 O código entregue deve estar compilando. Caso ocorram erros de compilação, o trabalho não será corrigido e a nota será zero.
R.: Sim
I4.9 Não é permitido o uso de funções lambda e técnicas de programação funcional da linguagem Java (ex.:, operador ->, lista.forEach(...),  stream(), filter(), etc.).
R.: Sim (não foram utilizados)
I5.1 A implementação do jogo deve utilizar algum tipo de coleção (ArrayList, HashMap, etc.) Pode ser na implementação de algum ator ou mundo ou poderia ser para mostrar um histórico de pontuação, por exemplo. A coleção utilizada precisa ter utilidade real no jogo.
R.: Sim. ArrayList em Colecao e Inventario; HashMap em Pontuacao (pontos por fase); HashSet em TelaColecao.
I5.2 A implementação deve usar herança: devem existir pelo menos três superclasses criadas por vocês (portanto, não contam as classes Actor e World). Além disso, as subclasses criadas precisam ter alguma implementação útil (ou seja, não vale uso "forçado" de herança).
R.: Sim. Superclasses: Vilao (Rato, Vigia, Cachorro, Patife), Item (ItemColecionavel e ItemUtilizavel, que geram Moeda, Radio, Arma, Vassoura, Cartao), Botao, MundoJogo, Passagem, Painel e TelaResultado.

COMENTÁRIOS (OPCIONAIS)
Algum comentário sobre o tema do trabalho?
R.: Nosso grupo gostou muito da ideia do trabalho final ser construir um jogo e, ainda mais, ser um jogo no tema da nossa escolha. Escolhemos uma temática que temos afinidade e isso serviu de motivação para realizarmos o trabalho.
