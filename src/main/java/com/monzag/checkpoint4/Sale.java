package com.monzag.checkpoint4;

public class Sale {

    private Integer id;
    private Integer customer_id;
    private String product_name;
    private Integer net_value;
    private Integer tax_rate;

    public Sale(Integer id, Integer customer_id, String product_name, Integer net_value, Integer tax_rate) {
        this.id = id;
        this.customer_id = customer_id;
        this.product_name = product_name;
        this.net_value = net_value;
        this.tax_rate = tax_rate;
    }

    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", product_name='" + product_name + '\'' +
                ", net_value=" + net_value +
                ", tax_rate=" + tax_rate +
                '}';
    }
}
