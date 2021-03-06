package de.immonet.shipWreck;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 * Created by spoppe on 02.09.2016.
 */
public class GameTest {



    @Test(timeout = 1000)
    public void overlayPreventionRunsNormallyNoOverlaysInShips()throws Exception{

        Game g = new Game();

        ArrayList<Integer> ship1Location= new ArrayList<>();
        ship1Location.add(1);
        ship1Location.add(2);
        ship1Location.add(3);
        Ship ship1 = new Ship(ship1Location,"1");

        ArrayList<Integer> ship2Location = new ArrayList<>();
        ship2Location.add(4);
        ship2Location.add(5);
        ship2Location.add(6);
        Ship ship2 = new Ship(ship2Location,"2");

        Ship[] ships = {ship1,ship2};

        g.overlayPrevention(ships);

    }

    @Test//(timeout = 1000)
    public void overlayPreventionRunsNormally1OverlayInShips()throws Exception{

        Game g = new Game();

        ArrayList<Integer> ship1Location= new ArrayList<>();
        ship1Location.add(1);
        ship1Location.add(2);
        ship1Location.add(3);
        Ship ship1 = new Ship(ship1Location,"1");

        ArrayList<Integer> ship2Location = new ArrayList<>();
        ship2Location.add(3);
        ship2Location.add(4);
        ship2Location.add(5);
        Ship ship2 = new Ship(ship2Location,"2");

        Ship[] ships = {ship1,ship2};

        g.overlayPrevention(ships);

    }

    @Test(timeout = 1000)
    public void overlayPreventionRunsNormally2OverlayInShips()throws Exception{

        Game g = new Game();

        ArrayList<Integer> ship1Location= new ArrayList<>();
        ship1Location.add(1);
        ship1Location.add(2);
        ship1Location.add(3);
        Ship ship1 = new Ship(ship1Location,"1");

        ArrayList<Integer> ship2Location = new ArrayList<>();
        ship2Location.add(2);
        ship2Location.add(3);
        ship2Location.add(4);
        Ship ship2 = new Ship(ship2Location,"2");

        Ship[] ships = {ship1,ship2};

        g.overlayPrevention(ships);

    }

    @Test(timeout = 1000)
    public void overlayPreventionRunsNormally3OverlayInShips()throws Exception{

        Game g = new Game();

        ArrayList<Integer> ship1Location= new ArrayList<>();
        ship1Location.add(1);
        ship1Location.add(2);
        ship1Location.add(3);
        Ship ship1 = new Ship(ship1Location,"1");

        ArrayList<Integer> ship2Location = new ArrayList<>();
        ship2Location.add(1);
        ship2Location.add(2);
        ship2Location.add(3);
        Ship ship2 = new Ship(ship2Location,"2");

        Ship[] ships = {ship1,ship2};

        g.overlayPrevention(ships);

    }






    @Test(timeout = 1000)
    public void evaluateTippReturnsVerfehltNumberNotMatchingLocation()throws Exception{

        Game g = new Game();

        ArrayList<Integer> ship1Location= new ArrayList<>();
        ship1Location.add(1);
        ship1Location.add(2);
        ship1Location.add(3);
        Ship ship1 = new Ship(ship1Location,"1");

        ArrayList<Integer> ship2Location = new ArrayList<>();
        ship2Location.add(4);
        ship2Location.add(5);
        ship2Location.add(6);
        Ship ship2 = new Ship(ship2Location,"2");

        ArrayList<Ship> shipList= new ArrayList<>();
        shipList.add(ship1);
        shipList.add(ship2);

        String s=g.evaluateTipp(12);

        assertEquals(s.contains("verfehlt"),true);
    }

    @Test(timeout = 1000)
    public void evaluateTippReturnsTrefferNumberMatchingLocation()throws Exception{
        Game g = new Game();

        ArrayList<Integer> ship1Location= new ArrayList<>();
        ship1Location.add(1);
        ship1Location.add(2);
        ship1Location.add(3);
        Ship ship1 = new Ship(ship1Location,"1");

        ArrayList<Integer> ship2Location = new ArrayList<>();
        ship2Location.add(4);
        ship2Location.add(5);
        ship2Location.add(6);
        Ship ship2 = new Ship(ship2Location,"2");

        ArrayList<Ship> shipList= new ArrayList<>();
        shipList.add(ship1);
        shipList.add(ship2);

        g.setShipList(shipList);

        String s=g.evaluateTipp(1);

        assertEquals(s.contains("Treffer"),true);
    }

    @Test(timeout = 1000)
    public void evaluateTippReturnsWurdeVersenktMatchingLocationsOfOneShip()throws Exception{
        Game g = new Game();

        ArrayList<Integer> ship1Location= new ArrayList<>();
        ship1Location.add(1);
        ship1Location.add(2);
        ship1Location.add(3);
        Ship ship1 = new Ship(ship1Location,"1");

        ArrayList<Integer> ship2Location = new ArrayList<>();
        ship2Location.add(16);
        ship2Location.add(23);
        ship2Location.add(30);
        Ship ship2 = new Ship(ship2Location,"2");

        ArrayList<Ship> shipList= new ArrayList<>();
        shipList.add(ship1);
        shipList.add(ship2);

        g.setShipList(shipList);

        g.evaluateTipp(1);
        g.evaluateTipp(2);
        String s=g.evaluateTipp(3);

        assertEquals(s.contains("wurde versenkt"),true);
    }

    @Test (timeout = 1000)
    public void evaluateTippReturnsAlleMatchingLocationsOfAllShips()throws Exception{
        Game g = new Game();

        ArrayList<Integer> ship1Location= new ArrayList<>();
        ship1Location.add(1);
        ship1Location.add(2);
        ship1Location.add(3);
        Ship ship1 = new Ship(ship1Location,"1");

        ArrayList<Integer> ship2Location = new ArrayList<>();
        ship2Location.add(16);
        ship2Location.add(23);
        ship2Location.add(30);
        Ship ship2 = new Ship(ship2Location,"2");

        ArrayList<Ship> shipList= new ArrayList<>();
        shipList.add(ship1);
        shipList.add(ship2);

        g.setShipList(shipList);

        g.evaluateTipp(1);
        g.evaluateTipp(2);
        g.evaluateTipp(3);
        g.evaluateTipp(16);
        g.evaluateTipp(23);
        g.evaluateTipp(30);
        String s =g.evaluateTipp(7);

        assertEquals(s.contains("alle"),true);
    }




    @Test
    public void overlapCompareReturnsTrueShipsAreEqual() throws Exception {

        Game g = new Game();

        ArrayList<Integer> ship1Location= new ArrayList<>();
        ship1Location.add(1);
        ship1Location.add(2);
        ship1Location.add(3);
        Ship ship1 = new Ship(ship1Location,"1");

        ArrayList<Integer> ship2Location = new ArrayList<>();
        ship2Location.add(1);
        ship2Location.add(2);
        ship2Location.add(3);
        Ship ship2 = new Ship(ship2Location,"2");

        boolean a = g.overlayCompare(ship1,ship2);

        assertEquals(a,true);
    }

    @Test
    public void overlapCompareReturnsTrueShipsHaveOneEqualPosition() throws Exception {

        Game g = new Game();

        ArrayList<Integer> ship1Location= new ArrayList<>();
        ship1Location.add(1);
        ship1Location.add(2);
        ship1Location.add(3);
        Ship ship1 = new Ship(ship1Location,"1");

        ArrayList<Integer> ship2location = new ArrayList<>();
        ship2location.add(3);
        ship2location.add(4);
        ship2location.add(5);
        Ship ship2 = new Ship(ship2location,"2");

        boolean a = g.overlayCompare(ship1,ship2);

        assertEquals(a,true);
    }

    @Test
    public void overlapCompareReturnsTrueShipsHaveTwoEqualPositions() throws Exception {

        Game g = new Game();

        ArrayList<Integer> ship1Location= new ArrayList<>();
        ship1Location.add(1);
        ship1Location.add(2);
        ship1Location.add(3);
        Ship ship1 = new Ship(ship1Location,"1");

        ArrayList<Integer> ship2Location = new ArrayList<>();
        ship2Location.add(2);
        ship2Location.add(3);
        ship2Location.add(4);
        Ship ship2 = new Ship(ship2Location,"2");

        boolean a = g.overlayCompare(ship1,ship2);

        assertEquals(a,true);
    }

    @Test
    public void overlapCompareReturnsFalseShipsAreDifferent() throws Exception {

        Game g = new Game();

        ArrayList<Integer> ship1Location= new ArrayList<>();
        ship1Location.add(1);
        ship1Location.add(2);
        ship1Location.add(3);
        Ship ship1 = new Ship(ship1Location,"1");

        ArrayList<Integer> ship2location = new ArrayList<>();
        ship2location.add(4);
        ship2location.add(5);
        ship2location.add(6);
        Ship ship2 = new Ship(ship2location,"2");


        boolean a = g.overlayCompare(ship1,ship2);

        assertEquals(a,false);
    }


}
