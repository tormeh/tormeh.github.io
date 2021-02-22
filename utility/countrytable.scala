case class Country(name: String, happiness: Double, lifeExpectancy: Double, broadbandSpeed: Double, medianWealth: Int, medianAge: Double) {
  val score: Double = happiness * lifeExpectancy + 0.25 * broadbandSpeed + (0.015 * medianWealth / (medianAge - 18))
  def toRow: String = {
    "<tr>" +
    "<td>" + name + "</td>" +
    "<td>" + score + "</td>" +
    "<td>" + happiness + "</td>" +
    "<td>" + lifeExpectancy + "</td>" +
    "<td>" + broadbandSpeed + "</td>" +
    "<td>" + medianWealth + "</td>" +
    "<td>" + medianAge + "</td>" +
    "</tr>"
  }
  def tableHeader: String = {
    """<th> name </th> <th> score </th>
    <th> happiness </th> <th> lifeExpectancy </th>
    <th> broadbandSpeed </th> <th> medianWealth </th>
    <th> medianAge </th>"""
  }
}

case class CountryList(countries: Seq[Country]) {
  def toTable: String = {
    """<table>
  <thead>
    <tr>
      """ + countries.head.tableHeader + """
    </tr>
  </thead>
  <tbody>
    """ + {countries.sortBy(_.score).reverse.foldLeft("")((x: String,y: Country) => x + "\n" + y.toRow): String} + """
  </tbody>
</table>"""
  }
}

//https://en.wikipedia.org/wiki/World_Happiness_Report#2020_World_Happiness_Report
//https://en.wikipedia.org/wiki/List_of_countries_by_life_expectancy
//https://www.speedtest.net/global-index
//https://en.wikipedia.org/wiki/List_of_countries_by_wealth_per_adult
//https://en.wikipedia.org/wiki/List_of_countries_by_median_age

val countries = CountryList(List(
  Country("Finland", 7.809, 81.9, 112.97, 55532, 42.8),
  Country("Denmark", 7.646, 80.9, 190.32, 58784, 42.0),
  Country("Switzerland", 7.560, 83.8, 187.08, 227891, 42.7),
//  country("Iceland", 7.504, 83.0, lolol, 165961), out because no internet data
  Country("Norway", 7.488, 82.4, 153.20, 70627, 39.5),
  Country("Netherlands", 7.499, 82.3, 136.84, 31057, 42.8),
  Country("Sweden", 7.353, 82.8, 165.97, 41582, 41.1),
  Country("New Zealand", 7.300, 82.3, 142.10, 116433, 37.2),
  Country("Austria", 7.294, 81.5, 78.21, 94070, 44.6),
  Country("Luxembourg", 7.238, 82.3, 147.60, 139789, 39.5),
  Country("Canada", 7.232, 82.4, 155.70, 107004, 41.8),
  Country("Australia", 7.223, 83.4, 58.76, 181361, 37.5),
  Country("United Kingdom", 7.165, 81.3, 82.36, 97452, 40.6),
  Country("Israel", 7.129, 83.0, 125.02, 58066, 30.4),
  Country("Costa Rica", 7.121, 80.3, 43.32, 11793, 32.6),
  Country("Ireland", 7.094, 82.3, 96.29, 104842, 37.8),
  Country("Germany", 7.076, 81.3, 113.55, 35313, 47.8),
  Country("United States", 6.940, 79.1, 179.06, 65904, 38.5),
  Country("Czechia", 6.911, 79.4, 72.89, 20854, 43.3),
  Country("Belgium", 6.864, 81.6, 100.88, 117093, 41.6),
  Country("United Arab Emirates", 6.791, 78.0, 125.43, 35315, 38.4),
  Country("Malta", 6.773, 82.5, 141.29, 76016, 42.3),
  Country("France", 6.664, 82.7, 188.03, 101942, 41.7),
  Country("Mexico", 6.465, 75.1, 44.94, 9944, 29.3),
  Country("Taiwan", 6.455, 76.43, 143.09, 70191, 42.3),
  Country("Hong Kong", 5.510, 84.9, 229.45, 146887, 45.6),
  Country("Japan", 5.871, 84.6, 138.30, 110408, 48.6),
  Country("Singapore", 6.377, 83.6, 247.54, 96967, 35.6),
  Country("Spain", 6.401, 83.5, 186.06, 95360, 43.9),
  Country("Italy", 6.387, 83.4, 79.62, 91889, 46.5),
  Country("South Korea", 5.872, 83.0, 174.66, 72198, 43.2),
  Country("Greece", 5.515, 82.2, 33.38, 40000, 45.3),
  Country("Portugal", 5.911, 82.1, 139.03, 44025, 44.6),
  Country("Thailand", 5.999, 77.2, 220.59, 3526, 39.0),
  Country("Romania", 6.124, 76.1, 198.01, 19582, 42.5),
  Country("Hungary", 6.000, 76.9, 185.92, 17666, 43.6),
  Country("Chile", 6.228, 80.2, 171.02, 19231, 35.5),
  Country("China", 5.124, 77.5, 162.12, 20942, 38.4),
))

println(countries.toTable)
