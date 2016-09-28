package com.github.jmetzz.cdi.atm_service;


public interface ATMTransport {

    void communicateWithBank(byte[] datapacket);
}
