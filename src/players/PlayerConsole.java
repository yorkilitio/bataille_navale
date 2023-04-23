package players;

import java.util.*;
import view.*;
import model.*;
import game.*;

//interface defining the methods of a player
public interface PlayerConsole{
    public void setChamp(Champ ch);

    public String toString();

    public Champ returnChamp();

    public void placerBateau(Bateau boat, int lig, int col, boolean direction);

    public void viser(int lig, int col, Obus obus);

    public void viserOpp(int lig, int col, Obus obus, Champ ch);
}