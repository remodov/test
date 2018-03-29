package ru.s7;

import ru.s7.account.Account;
import ru.s7.account.AccountTransferPerform;
import ru.s7.account.TransferThread;

import java.math.BigDecimal;

public class Main {

    private final static AccountTransferPerform accountTransferPerform = new AccountTransferPerform();

    public static void main(String[] args) throws InterruptedException {
        Account A = new Account(1L,new BigDecimal(200));
        Account B = new Account(2L,new BigDecimal(200));

        Runnable transferFromAToB = new TransferThread(accountTransferPerform,A,B,new BigDecimal(200));
        Runnable transferFromBToA = new TransferThread(accountTransferPerform,B,A,new BigDecimal(100));

        Thread thread1 = new Thread(transferFromAToB);
        Thread thread2 = new Thread(transferFromBToA);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Result transfers: " +  A.toString() + " " + B.toString() );
    }
}
