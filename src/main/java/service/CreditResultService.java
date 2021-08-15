package service;

import entity.Client;
import model.ClientModel;

public class CreditResultService {

    public static boolean creditResult(Long monthPay, Long iin){
        Client client = ClientModel.findByIin(iin);
        return client.getSalary() >= monthPay * 2;
    }
}
