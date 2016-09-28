package com.github.jmetzz.cdi.atm_service;


import java.math.BigDecimal;

public interface AutomatedTellerMachine {

        void deposit(BigDecimal value);

        void withdraw(BigDecimal value);

}
