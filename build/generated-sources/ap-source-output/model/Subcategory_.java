package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Category;
import model.Product;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-05-21T22:46:55")
@StaticMetamodel(Subcategory.class)
public class Subcategory_ { 

    public static volatile SingularAttribute<Subcategory, Integer> id;
    public static volatile SingularAttribute<Subcategory, Category> categoryid;
    public static volatile SingularAttribute<Subcategory, String> description;
    public static volatile ListAttribute<Subcategory, Product> productList;
    public static volatile SingularAttribute<Subcategory, String> name;

}