package com.example;

import com.example.models.Game;

public class App 
{
    public static void main( String[] args )
    {
        Game game = new Game();
        game.intro();
        game.play();
    }
}
