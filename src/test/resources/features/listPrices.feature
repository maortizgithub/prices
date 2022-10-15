Feature: Price Tests

  Scenario: A stored prices, return list
    Given A request
    Then The System returns a list of prices

  Scenario Outline: A request with different values check status response and correct price
    Given A search with <brandId>, <productId>, <date>
    When execute a post request
    Then The System returns a <status> HTTP Response and prices is <price>

    Examples:
      |brandId|productId|date|price|status|
      |1|35455|"14/06/2020 10:00"|35.50|200|
      |1|35455|"14/06/2020 16:00"|25.45|200|
      |1|35455|"14/06/2020 21:00"|35.50|200|
      |1|35455|"15/06/2020 10:00"|30.50|200|
      |1|35455|"16/06/2020 21:00"|38.95|200|
      |2|35455|"16/06/2020 21:00"|0.00|404|