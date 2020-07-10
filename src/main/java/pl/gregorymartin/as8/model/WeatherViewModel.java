package pl.gregorymartin.as8.model;



import javax.persistence.*;

@Entity
@Table(name ="weather")
public
class WeatherViewModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double temperature;
    private String cityName;
    private String country;
    private String mainType;
    private String description;

    public WeatherViewModel() {
    }

    public WeatherViewModel(Weather source) {
        this.cityName = source.getName();
        this.country = source.getSys().getCountry();
        this.mainType = source.getWeather().get(0).getMain();
        this.description = source.getWeather().get(0).getDescription();
        this.temperature = source.getMain().getTemp();
    }


    public String getCityName() {
        return cityName;
    }

    public void setCityName(final String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public String getMainType() {
        return mainType;
    }

    public void setMainType(final String mainType) {
        this.mainType = mainType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(final Double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "WeatherDatabaseModel{" +
                ", cityName='" + cityName + '\'' +
                ", country='" + country + '\'' +
                ", mainType='" + mainType + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
