/*  Listing Enpoints:

/order/

Pour la prise de commande de l'Utilisateur.

JSON attendu:

    {
    "id_order": 101,
    "id_client_table": 5,
    "id_bar_user": 201,
    "price_order": 21.50
    "status_order": 25.51
    "order_product_extra": [
      {
        "id_order_product_extra": 301,
        "id_product": 1001,
        "name_product": "Cheeseburger",
        "price_product": 8.50,
        "css_hexadecimal_color": "#FF5733",
        "status_product":"0"
        "order_extra": [
          {
            "id_extra": 2001,
            "name_extra": "Cheese",
            "price_extra": 1.50
          },
          {
            "id_extra": 2002,
            "name_extra": "Bacon",
            "price_extra": 2.00
          },
          {
            "id_extra": 2003,
            "name_extra": "Lettuce",
            "price_extra": 0.75
          }
        ]
      },
      {
        "id_order_product_extra": 25,
        "id_product": 154,
        "name_product": "burger",
        "price_product": 8.50,
        "css_hexadecimal_color": "#FF5733",
        "status_product":"1"
        "order_extra": [
          {
            "id_extra": 2004,
            "name_extra": "Ketchup",
            "price_extra": 0.50
          },
          {
            "id_extra": 2005,
            "name_extra": "Cheese Sauce",
            "price_extra": 1.00
          }
        ]
      },
        ]
      }
    ]
  }

*/


 