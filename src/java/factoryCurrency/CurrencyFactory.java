/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoryCurrency;
/**
 *
 * @author VolkanOzkan
 */
public class CurrencyFactory
{
    public static Currency createCurrency (String country) 
    {
       if (country.equalsIgnoreCase ("Turkey"))
       {
            return new TurkishLira();
       }
       else if(country.equalsIgnoreCase ("Europe"))
       {
            return new Euro();
       }
       else if(country.equalsIgnoreCase ("US"))
       {
            return new USDollar();
       }
       
       throw new IllegalArgumentException("No currency");
       }
}
