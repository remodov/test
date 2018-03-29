package ru.s7.account;

import java.math.BigDecimal;

/**
 * Запуск передачи денег в несколько потоков
 */
public class TransferThread implements Runnable {

    private final AccountTransferPerform accountTransferPerform;
    private final Account accountFrom;
    private final Account accountTo;
    private final BigDecimal sum;

    public TransferThread(AccountTransferPerform accountTransferPerform, Account accountFrom, Account accountTo, BigDecimal sum) {
        this.accountTransferPerform = accountTransferPerform;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.sum = sum;
    }

    @Override
    public void run() {
        accountTransferPerform.transfer(accountFrom,accountTo,sum);
    }
}
