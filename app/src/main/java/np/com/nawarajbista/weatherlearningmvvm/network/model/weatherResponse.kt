package np.com.nawarajbista.weatherlearningmvvm.network.model

data class weatherResponse(
    val consolidated_weather: List<ConsolidatedWeather>,
    val time: String,
    val title: String,
    val woeid: Int
)