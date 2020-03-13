/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duydd.utils;

import duydd.crawl.DrawlData;

/**
 *
 * @author DELL
 */
public class MainClass {
    public static void main(String[] args) {
          String result = XMLUtils.parseHTML("https://www.calorieking.com", "/us/en/");
          DrawlData.getCategoriesLink(result);
          result = XMLUtils.parseHTML("", "https://www.weightlossresources.co.uk/calories/calorie_counter/vegetables.htm");
          DrawlData.getVegetableDetail(result);
    }
    
}
