/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylib.games.cards.cardsAgainstHumanity;

import mylib.games.cards.Card;

/**
 *
 * @author User
 */
public abstract class CAHCard extends Card {
    
    public CAHCard(String description) {
        super("", description, 0);
    }
    
}
