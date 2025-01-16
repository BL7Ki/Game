package com.example.models;

import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    // Método para exibir a introdução do jogo
    public void intro() {
        System.out.println("Hello, welcome to the game: Rock, Paper, Scissors");
        System.out.println("First of all, Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + ", let's begin!");
    }

    // Método principal para o jogo
    public void play() {
        boolean keepPlaying = true;
        while (keepPlaying) {
            System.out.println("Enter your choice: (r)ock, (p)aper, (s)cissors");
            String playerChoice = scanner.nextLine().toLowerCase();

            // Gera a escolha aleatória do computador
            String[] options = {"r", "p", "s"};
            String computerChoice = options[random.nextInt(3)];

            // Exibe a escolha do computador
            System.out.println("Computer chooses: " + getChoiceName(computerChoice));

            // Exibe a escolha do jogador e valida
            if (!isValidChoice(playerChoice)) {
                System.out.println("Invalid choice! Please try again.");
                continue;
            } else {
                System.out.println("You choose: " + getChoiceName(playerChoice));
            }

            // Determina o vencedor
            String result = determineWinner(playerChoice, computerChoice);
            System.out.println(result);

            // Pergunta ao jogador se deseja jogar novamente
            System.out.println("Do you want to play again? (yes/no)");
            String replayChoice = scanner.nextLine().toLowerCase();
            keepPlaying = replayChoice.equals("yes");
        }
        System.out.println("Thanks for playing! Goodbye.");
    }

    // Método para retornar o nome completo da escolha
    private String getChoiceName(String choice) {
        switch (choice) {
            case "r":
                return "ROCK";
            case "p":
                return "PAPER";
            case "s":
                return "SCISSORS";
            default:
                return "INVALID";
        }
    }

    // Método para verificar se a escolha do jogador é válida
    private boolean isValidChoice(String choice) {
        return choice.equals("r") || choice.equals("p") || choice.equals("s");
    }

    // Método para determinar o vencedor
    private String determineWinner(String player, String computer) {
        if (player.equals(computer)) {
            return "It's a DRAW!";
        }
        if ((player.equals("r") && computer.equals("s")) ||
            (player.equals("p") && computer.equals("r")) ||
            (player.equals("s") && computer.equals("p"))) {
            return "You WIN!";
        } else {
            return "You LOSE!";
        }
    }
}
