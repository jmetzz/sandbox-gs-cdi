package com.github.jmetzz.cdi.atm_service;


import java.math.BigDecimal;
import java.util.logging.Logger;

public class AutomatedTellerMachineImpl implements AutomatedTellerMachine {
    private static Logger logger = Logger.getLogger(AutomatedTellerMachineImpl.class.getName());

    private ATMTransport transport;

    @Override
    public void deposit(BigDecimal value) {
        logger.info("Deposit called");
        transport.communicateWithBank(null);
    }

    @Override
    public void withdraw(BigDecimal value) {
        logger.info("Withdraw called");
        transport.communicateWithBank(null);
    }
}
