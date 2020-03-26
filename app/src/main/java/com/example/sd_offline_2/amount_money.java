package com.example.sd_offline_2;

public class amount_money {

    private  static  amount_money instance = new amount_money();


    public static amount_money getInstance() {
        return instance;
    }

    public static void setInstance(amount_money instance) {
        amount_money.instance = instance;
    }

    private  amount_money()
    {

    }

    private  int donation;

    public  int getDonation()
    {
        return  donation;
    }
    public  void setDonation(int money)
    {
       this. donation+=money;
    }

}
