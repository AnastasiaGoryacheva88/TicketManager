package ru.netology.javaqa;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketManagerTest {

    Ticket ticket1 = new Ticket(1, 1200, "VKO", "KZN", 95);
    Ticket ticket2 = new Ticket(2, 1500, "VKO", "KZN", 95);
    Ticket ticket3 = new Ticket(3, 2100, "VKO", "KZN", 95);
    Ticket ticket4 = new Ticket(4, 3200, "VKO", "KZN", 95);
    Ticket ticket5 = new Ticket(5, 1000, "VKO", "KZN", 95);
    Ticket ticket6 = new Ticket(6, 5000, "KZN", "VKO", 95);
    Ticket ticket7 = new Ticket(7, 4700, "KZN", "VKO", 95);
    Ticket ticket8 = new Ticket(8, 2000, "KZN", "VKO", 95);
    Ticket ticket9 = new Ticket(9, 2000, "KZN", "VKO", 96);

    @Test
    public void findAllTest() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket5, ticket1, ticket2, ticket3, ticket4};
        Ticket[] actual = manager.findAll("VKO", "KZN");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findByIdTest() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.findById(3);

        Ticket[] actual = manager.findAll("VKO", "KZN");
        Ticket[] expected = {ticket3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void nullTest() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Ticket[] actual = manager.findAll("MOW", "DXB");
        Ticket[] expected = {};

        assertArrayEquals(expected, actual);

    }


    @Test
    public void removeTest() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.removeAll();
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.removeById(4);

        Ticket[] actual = manager.findAll("VKO", "KZN");
        Ticket[] expected = {ticket5, ticket3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllIfSamePriceTest() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] expected = {ticket8, ticket9, ticket7, ticket6};
        Ticket[] actual = manager.findAll("KZN", "VKO");
    }

}

