package ru.s7.account;

import java.math.BigDecimal;

/**
 * Класс для осуществления перевода из одного аккаунта в другой
 */
public class AccountTransferPerform {

    /**
     * Метод осуществляет перевод денег между двумя аккаунтами.
     * Блокировка только тех аккаунтов, между которыми происходит перевод денег.
     * Чтобы не было дедлока, воспроизводим один и тот же порядок блокировки.
     * @param accountFrom аккаунт откуда
     * @param accountTo аккаунт куда
     * @param sum - сумма
     */
    public void transfer(Account accountFrom, Account accountTo, BigDecimal sum)
    {
        Object lock1 =  accountFrom.getAccountId() < accountTo.getAccountId() ? accountFrom.getLock()  : accountTo.getLock();
        Object lock2 =  accountFrom.getAccountId() < accountTo.getAccountId() ? accountTo.getLock()  : accountFrom.getLock();

        //дополнительных проверок не вешал, показал упорядочивание блокировки
        synchronized(lock1) {
            synchronized(lock2) {

                BigDecimal fromValue = accountFrom.getAmount();
                BigDecimal toValue = accountTo.getAmount();

                accountFrom.setAmount(fromValue.add(sum.negate()));
                accountTo.setAmount(toValue.add(sum));
            }
        }
    }
}
