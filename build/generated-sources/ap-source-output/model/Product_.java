package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Subcategory;
import model.Supplier;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-05-17T19:52:09")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Integer> id;
    public static volatile SingularAttribute<Product, Double> price;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, String> barcode;
    public static volatile SingularAttribute<Product, Integer> quantity;
    public static volatile SingularAttribute<Product, String> attributes;
    public static volatile SingularAttribute<Product, Subcategory> subcategoryid;
    public static volatile SingularAttribute<Product, Supplier> supplierid;

}