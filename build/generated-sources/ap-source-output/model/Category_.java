package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Subcategory;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-05-17T19:52:09")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, Integer> id;
    public static volatile SingularAttribute<Category, Double> tax;
    public static volatile SingularAttribute<Category, String> name;
    public static volatile ListAttribute<Category, Subcategory> subcategoryList;

}