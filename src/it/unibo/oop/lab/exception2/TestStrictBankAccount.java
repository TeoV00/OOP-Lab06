package it.unibo.oop.lab.exception2;

import org.junit.Test;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;
/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
        AccountHolder marioRossi = new AccountHolder("Mario", "Rossi", 1234);
        AccountHolder paoloPini = new AccountHolder("Paolo", "Pini", 00001);
        BankAccount acc1 = new StrictBankAccount(marioRossi.getUserID(), 10000, 10);
        BankAccount acc2 = new StrictBankAccount(paoloPini.getUserID(), 10000, 10);
        
        while(acc1.getBalance() > 0) {
            acc1.withdraw(marioRossi.getUserID(), 1000);
        }
        try {
            acc1.withdraw(marioRossi.getUserID(), 1000);
            fail("Not go over, not enough money");
            acc1.withdraw(marioRossi.getUserID(), 50);
        } catch (NotEnoughFoundsException e) {
            assertTrue(e.getMessage().contains("Not Enough Money"));
        }
        
       try {
           acc2.deposit(marioRossi.getUserID(), 200);
           fail("You won't go over");
           acc2.deposit(paoloPini.getUserID(), 200);
       }
       catch(WrongAccountHolderException e) {
           assertTrue(e.getMessage().contains("Not Allowed Account"));
       }
    }
}
