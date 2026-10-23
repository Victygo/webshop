package se.iths.viktoriia.webshop;

public interface OutInputHandler {
    /** Visar ett meddelande och returnerar användarens svar. */
    String prompt(String message);

    /** Visar information för användaren. */
    void info(String message);

    /** Visar menyn och returnerar användarens val. */
    String menu();
}
