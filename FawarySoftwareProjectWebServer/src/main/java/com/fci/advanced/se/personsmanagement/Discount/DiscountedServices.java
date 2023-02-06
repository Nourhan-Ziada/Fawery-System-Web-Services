package com.fci.advanced.se.personsmanagement.Discount;



import java.util.*;


public class DiscountedServices {

    private static DiscountedServices discounts;
    private Set<String> allDiscounts = new HashSet<>();

    public Set<String>  getAllDiscounts() {
        return allDiscounts;
    }

    public void setAllDiscounts(Set<String> allDiscounts) {
        this.allDiscounts = allDiscounts;
    }

    private DiscountedServices(Set<String> allDiscounts) {
        this.allDiscounts = allDiscounts;
    }
    public static DiscountedServices getInstance(Set<String> allDiscounts)
    {
        if(discounts == null)
            discounts = new DiscountedServices(allDiscounts);

        return discounts ;
    }
}
