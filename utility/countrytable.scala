case class Country(
  name: String,
  happiness: Double,
  lifeExpectancy: Double,
  broadbandSpeed: Double,
  medianWealth: Int,
  medianAge: Double,
  landlinePercentage: Double,
  broadbandPercentage: Double,
  moralFreedom: Double
  ) {
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
    "<td>" + landlinePercentage + "</td>" +
    "<td>" + broadbandPercentage + "</td>" +
    "<td>" + moralFreedom + "</td>" +
    "</tr>"
  }
  def tableHeader: String = {
    """<th> name </th> <th> score </th>
    <th> happiness </th> <th> lifeExpectancy </th>
    <th> broadbandSpeed </th> <th> medianWealth </th>
    <th> medianAge </th> <th> landlinePercentage </th>
    <th> broadbandPercentage </th> <th> moralFreedom </th>"""
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
//https://ourworldindata.org/technology-adoption
//https://en.wikipedia.org/wiki/World_Index_of_Moral_Freedom

val countries = CountryList(List(
  Country("Finland", 7.809, 81.9, 112.97, 55532, 42.8, 6.85, 30.95, 75.57),
  Country("Denmark", 7.646, 80.9, 190.32, 58784, 42.0, 25.11, 43.7, 83.39),
  Country("Switzerland", 7.560, 83.8, 187.08, 227891, 42.7, 43.33, 45.42, 83.28),
//  country("Iceland", 7.504, 83.0, lolol, 165961), out because no internet data
  Country("Norway", 7.488, 82.4, 153.20, 70627, 39.5, 14.05, 40.23, 76.15),
  Country("Netherlands", 7.499, 82.3, 136.84, 31057, 42.8, 38.45, 42.33, 95.44),
  Country("Sweden", 7.353, 82.8, 165.97, 41582, 41.1, 28.2, 37.7, 71.69),
  Country("New Zealand", 7.300, 82.3, 142.10, 116433, 37.2, 29.07, 33.62, 76.45),
  Country("Austria", 7.294, 81.5, 78.21, 94070, 44.6, 43.08, 28.75, 86.06),
  Country("Luxembourg", 7.238, 82.3, 147.60, 139789, 39.5, 47.18, 36.49, 87.61),
  Country("Canada", 7.232, 82.4, 155.70, 107004, 41.8, 40.14, 38.01, 91.94),
  Country("Australia", 7.223, 83.4, 58.76, 181361, 37.5, 34.6, 32.4, 82.80),
  Country("United Kingdom", 7.165, 81.3, 82.36, 97452, 40.6, 50.08, 39.31, 69.2),
  Country("Israel", 7.129, 83.0, 125.02, 58066, 30.4, 38.93, 28.14, 74.27),
  Country("Costa Rica", 7.121, 80.3, 43.32, 11793, 32.6, 17.19, 15.17, 62.03),
  Country("Ireland", 7.094, 82.3, 96.29, 104842, 37.8, 38.68, 29.43, 74.39),
  Country("Germany", 7.076, 81.3, 113.55, 35313, 47.8, 54.07, 40.45, 84.53),
  Country("United States", 6.940, 79.1, 179.06, 65904, 38.5, 36.95, 33.85, 73.68),
  Country("Czechia", 6.911, 79.4, 72.89, 20854, 43.3, 36.95, 28.82, 83.21),
  Country("Belgium", 6.864, 81.6, 100.88, 117093, 41.6, 37.2, 38.31, 90.82),
  Country("United Arab Emirates", 6.791, 78.0, 125.43, 35315, 38.4, 24.69, 14.00, 12.14),
  Country("Malta", 6.773, 82.5, 141.29, 76016, 42.3, 55.77, 42.09, 70.73),
  Country("France", 6.664, 82.7, 188.03, 101942, 41.7, 59.54, 43.75, 75.00),
  Country("Mexico", 6.465, 75.1, 44.94, 9944, 29.3, 15.95, 13.26, 85.14),
  //Country("Taiwan", 6.455, 76.43, 143.09, 70191, 42.3),
  Country("Hong Kong", 5.510, 84.9, 229.45, 146887, 45.6, 57.93, 35.92, 36.86),
  Country("Japan", 5.871, 84.6, 138.30, 110408, 48.6, 50.16, 31.68, 53.53),
  Country("Singapore", 6.377, 83.6, 247.54, 96967, 35.6, 34.74, 25.76, 53.32),
  Country("Spain", 6.401, 83.5, 186.06, 95360, 43.9, 42.46, 31.22, 86.05),
  Country("Italy", 6.387, 83.4, 79.62, 91889, 46.5, 34.87, 27.94, 84.61),
  Country("South Korea", 5.872, 83.0, 174.66, 72198, 43.2, 52.65, 41.58, 54.38),
  Country("Greece", 5.515, 82.2, 33.38, 40000, 45.3, 46.39, 33.86, 74.42),
  Country("Portugal", 5.911, 82.1, 139.03, 44025, 44.6, 46.77, 34.6, 95.43),
  Country("Thailand", 5.999, 77.2, 220.59, 3526, 39.0, 4.22, 11.89, 36.20),
  Country("Romania", 6.124, 76.1, 198.01, 19582, 42.5, 19.77, 24.29, 57.73),
  Country("Hungary", 6.000, 76.9, 185.92, 17666, 43.6, 32.21, 30.41, 69.27),
  Country("Chile", 6.228, 80.2, 171.02, 19231, 35.5, 17.69, 16.94, 72.43),
  Country("China", 5.124, 77.5, 162.12, 20942, 38.4, 13.75, 26.86, 36.86),
  Country("Russia", 5.546, 72.9, 81.16, 3683, 40.3, 21.66, 21.44, 45.47),
  Country("Turkey", 5.132, 77.7, 30.51, 6568, 32.2, 14.01, 14.77, 42.14),
  Country("Iran", 4.672, 76.7, 19.42, 5254, 31.7, 38.42, 12.39, 15.51),
  Country("Pakistan", 5.693, 67.3, 10.84, 1766, 22.0, 1.49, 0.93, 22.2),
  Country("Botswana", 3.479, 69.6, 9.71, 4550, 25.7, 6.16, 2.13, 49.53),
  Country("India", 3.573, 70.4, 54.73, 3042, 28.7, 1.73, 1.33, 51.39),
  Country("Brazil", 6.376, 76.7, 79.30, 5031, 33.2, 19.53, 13.7, 74.46),
))

println(countries.toTable)
