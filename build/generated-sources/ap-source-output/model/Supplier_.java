package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Product;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-05-17T19:52:09")
@StaticMetamodel(Supplier.class)
public class Supplier_ { 

    public static volatile SingularAttribute<Supplier, Integer> id;
    public static volatile SingularAttribute<Supplier, String> phone;
    public static volatile SingularAttribute<Supplier, String> email;
    public static volatile ListAttribute<Supplier, Product> productList;
    public static volatile SingularAttribute<Supplier, String> name;
    public static volatile SingularAttribute<Supplier, String> city;

}