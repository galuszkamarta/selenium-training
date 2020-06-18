package Litecart.model;

import java.io.File;

/**
 * Created by m on 2020-04-18.
 */
public class Category {

  private String code;
  private String nameCategory;
  private String googleTaxonomyID;
  private String listStyle;
  private File photo;


  public static Category.Builder newEntity() { return new Category().new Builder(); }

  public String getCode() {
    return code;
  }

  public String getNameCategory() {
    return nameCategory;
  }

  public String getGoogleTaxonomyID() {
    return googleTaxonomyID;
  }

  public String getListStyle() {
    return listStyle;
  }

  public File getPhoto() {
    return photo;
  }



  public class Builder {
    private Builder() {}
    public Litecart.model.Category.Builder withCode(String code) { Litecart.model.Category.this.code = code; return this; }
    public Litecart.model.Category.Builder withNameCategory(String nameCategory) { Litecart.model.Category.this.nameCategory = nameCategory; return this; }
    public Litecart.model.Category.Builder withGoogleTaxonomyID(String googleTaxonomyID) { Litecart.model.Category.this.googleTaxonomyID = googleTaxonomyID; return this; }
    public Litecart.model.Category.Builder withListStyle(String listStyle) { Litecart.model.Category.this.listStyle = listStyle; return this; }
    public Litecart.model.Category.Builder withPhoto(File photo) { Litecart.model.Category.this.photo = photo; return this; }

    public Litecart.model.Category build() {return Litecart.model.Category.this; }
  }
}
