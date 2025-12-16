# 🐐 Corre Cabrito (Jogo de Tabuleiro Digital) 🦅

## Descrição do Projeto

"Corre Cabrito" é uma adaptação digital de um jogo de tabuleiro estratégico implementado em Java utilizando a biblioteca Swing. O jogo envolve dois jogadores, o **Cabrito (C)** e o **Carcará (A)**, em um tabuleiro de 6 posições. O objetivo do Carcará é capturar o Cabrito, enquanto o Cabrito deve usar sua habilidade especial para evitar a captura.

O projeto foi desenvolvido por:
* **SIDNEI CORREIA JUNIOR** ([2510102122]) - Interface Gráfica (Swing) e Elementos Visuais
* **ADRIANO MOISÉS** ([2510101615]) - Lógica do Jogo, Regras, Exceções e Controle de Estado

---

## 🎲 Regras do Jogo

O jogo é jogado em um tabuleiro de 6 nós interligados (c1 a c6).

### Peças

| Peça | Símbolo | Jogador | Posição Inicial | Objetivo |
| :--- | :---: | :--- | :--- | :--- |
| **Cabrito** | `C` | Cabrito | `c1` | Evitar a captura. |
| **Carcará** | `A` | Carcará | `c5` | Capturar o Cabrito. |

### Movimentação

* **Turno:** O **Cabrito** começa o jogo. Os turnos se alternam.
* **Movimento Normal:** As peças podem se mover apenas para um nó adjacente (diretamente conectado) que esteja vazio.
* **Regra do Cabrito:** O Cabrito **não pode** se mover para a posição do Carcará.
* **Regra do Carcará:** O Carcará **pode** se mover para a posição do Cabrito para capturá-lo (desde que seja um movimento adjacente).

### ⚡ Habilidade Especial (Super Pulo)

* **Apenas para o Cabrito:** O Cabrito pode usar um **Super Pulo** uma única vez durante o jogo (`superPuloUsado = true`).
* **Condição:** O Super Pulo permite que o Cabrito se mova para qualquer posição **vazia** no tabuleiro, mesmo que não seja adjacente.

### Fim de Jogo

* O jogo termina imediatamente quando o **Carcará captura o Cabrito**.

---

## 📁 Estrutura do Projeto

O projeto é composto pelas seguintes classes principais:

| Arquivo | Descrição |
| :--- | :--- |
| `Main.java` | Ponto de entrada do aplicativo. Inicializa a janela e a música de fundo. Contém a lógica de áudio. |
| `Window.java` | Configura a janela principal (JFrame), painéis e adiciona todos os elementos visuais. |
| `Logic.java` | **Classe principal da lógica do jogo.** Contém as regras de movimentação, o controle de turno, a validação de adjacência (`mapaAdjacencias`), o Super Pulo e a verificação de fim de jogo. |
| `Elements.java` | Interface que define todos os componentes Swing e JComponent (`JLabel`, `JPanel`, `JMenu`, `Circle`, `Line`) usados na interface gráfica. |
| `Circle.java` | Componente personalizado que representa os nós do tabuleiro. Gerencia a cor e a letra (C/A) da peça, exibindo as imagens correspondentes. |
| `Line.java` | Componente personalizado que desenha as linhas de conexão entre os nós do tabuleiro. |
| `VolumeControl.java` | Implementa um `JFrame` *singleton* para controle de volume da música de fundo via `JSlider` (usando `FloatControl`). |

---

## ⚙️ Configuração e Execução

### Requisitos

* Java Development Kit (JDK) 8 ou superior.

### Como Compilar e Rodar (Linux/macOS)

1.  **Compile os arquivos `.java`:**
    ```bash
    javac Main.java Window.java Logic.java Elements.java Circle.java Line.java VolumeControl.java
    ```
2.  **Execute o jogo:**
    ```bash
    java Main
    ```

### Como Compilar e Rodar (Windows - Prompt de Comando)

1.  **Compile os arquivos `.java`:**
    ```bash
    javac *.java
    ```
2.  **Execute o jogo:**
    ```bash
    java Main
    ```

### Observações sobre Recursos

* O projeto depende dos diretórios `images/` (para as imagens das peças) e `songs/` (para os arquivos de áudio de fundo e cliques), que devem estar presentes na raiz do projeto para a execução.
