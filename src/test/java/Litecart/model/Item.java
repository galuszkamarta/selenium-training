package Litecart.model;

/**
 * Created by m on 2020-02-06.
 */
public class Item {

    private String size;
    private String quantity;

    public static Litecart.model.Item.Builder newEntity() { return new Litecart.model.Item().new Builder(); }

    public String getSize() {
      return size;
    }

    public String getQuantity() {
      return quantity;
    }



    public class Builder {
      private Builder() {}
      public Litecart.model.Item.Builder withSize(String size) { Litecart.model.Item.this.size = size; return this; }
      public Litecart.model.Item.Builder withQuantity(String quantity) { Litecart.model.Item.this.quantity = quantity; return this; }
      public Litecart.model.Item build() {return Litecart.model.Item.this; }
    }

  }
