case class Country(name: String, happiness: Double, lifeExpectancy: Double, broadbandSpeed: Double) {
  val utility: Double = happiness * lifeExpectancy + 0.5 * broadbandSpeed
  def toRow: String = {
    "<tr>" +
    "<td>" + name + "</td>" +
    "<td>" + utility + "</td>" +
    "<td>" + happiness + "</td>" +
    "<td>" + lifeExpectancy + "</td>" +
    "<td>" + broadbandSpeed + "</td>" +
    "</tr>"
  }
  def tableHeader: String = {
    """<th> name </th> <th> utility </th>
    <th> happiness </th> <th> lifeExpectancy </th>
    <th> broadbandSpeed </th>"""
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
    """ + {countries.sortBy(_.utility).reverse.foldLeft("")((x: String,y: Country) => x + "\n" + y.toRow): String} + """
  </tbody>
</table>"""
  }
}

//https://en.wikipedia.org/wiki/World_Happiness_Report#2020_World_Happiness_Report
//https://en.wikipedia.org/wiki/List_of_countries_by_life_expectancy
//https://www.speedtest.net/global-index

val countries = CountryList(List(
  Country("Finland", 7.809, 81.9, 112.97),
  Country("Denmark", 7.646, 80.9, 190.32),
  Country("Switzerland", 7.560, 83.8, 187.08),
//  country("Iceland", 7.504, 83.0), out because no internet data
  Country("Norway", 7.488, 82.4, 153.20),
  Country("Netherlands", 7.499, 82.3, 136.84),
  Country("Sweden", 7.353, 82.8, 165.97),
  Country("New Zealand", 7.300, 82.3, 142.10),
  Country("Austria", 7.294, 81.5, 78.21),
  Country("Luxembourg", 7.238, 82.3, 147.60),
  Country("Canada", 7.232, 82.4, 155.70),
  Country("Australia", 7.223, 83.4, 58.76),
  Country("United Kingdom", 7.165, 81.3, 82.36),
  Country("Israel", 7.129, 83.0, 125.02),
  Country("Costa Rica", 7.121, 80.3, 43.32),
  Country("Ireland", 7.094, 82.3, 96.29),
  Country("Germany", 7.076, 81.3, 113.55),
  Country("United States", 6.940, 79.1, 179.06),
  Country("Czechia", 6.911, 79.4, 72.89),
  Country("Belgium", 6.864, 81.6, 100.88),
  Country("United Arab Emirates", 6.791, 78.0, 125.43),
  Country("Malta", 6.773, 82.5, 141.29),
  Country("France", 6.664, 82.7, 188.03),
  Country("Mexico", 6.465, 75.1, 44.94),
  Country("Taiwan", 6.455, 76.43, 143.09),
  Country("Hong Kong", 5.510, 84.9, 229.45),
  Country("Japan", 5.871, 84.6, 138.30),
  Country("Singapore", 6.377, 83.6, 247.54),
  Country("Spain", 6.401, 83.5, 186.06),
  Country("Italy", 6.387, 83.4, 79.62),
  Country("South Korea", 5.872, 83.0, 174.66),
  Country("Greece", 5.515, 82.2, 33.38),
  Country("Portugal", 5.911, 82.1, 139.03),
))

println(countries.toTable)
