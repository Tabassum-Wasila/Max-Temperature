import edu.duke.*;
import org.apache.commons.csv.*;
public class CSVMax {
	public CSVRecord hottestHourInDay(CSVParser parser)
	{
		CSVRecord largestSoFar = null;
		for(CSVRecord currentRow : parser)
		{
			if(largestSoFar == null)
				largestSoFar = currentRow;
			else
			{
				double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
				double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
				if(currentTemp > largestTemp)
					largestSoFar = currentRow;
			}
		}
		return largestSoFar;
	}
	public void testHottestHourInDay()
	{
		FileResource fr = new FileResource("C://Users/Tabassum Wasila Sus/Downloads/nc_weather/nc_weather/2012/weather-2012-01-01.csv");
		CSVRecord largest = hottestHourInDay(fr.getCSVParser());
		System.out.println("hottest temperature was " + largest.get("TemperatureF") + " at " + largest.get("TimeEST"));
	}
}
